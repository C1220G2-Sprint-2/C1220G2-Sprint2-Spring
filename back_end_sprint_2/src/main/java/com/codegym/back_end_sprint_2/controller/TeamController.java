package com.codegym.back_end_sprint_2.controller;


import com.codegym.back_end_sprint_2.dto.DtoTeam;
import com.codegym.back_end_sprint_2.config.MailConfig;
import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.service.IProjectService;
import com.codegym.back_end_sprint_2.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

import com.codegym.back_end_sprint_2.model.entities.TeamDto;
import com.codegym.back_end_sprint_2.service.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private IProjectService projectService;
    @Autowired
    private ITeamService teamService;
    @Autowired
    private IMailService mailService;
    @Autowired
    private JavaMailSender mailSender;

//Code Huy - ------------------------------------------------------------------

    @PostMapping("/postTeam")
    public ResponseEntity<Team> save(@RequestBody TeamDto teamDto) throws MessagingException {
        Team team = teamService.teamMapping(teamDto);
        Team teamResponse= teamService.save(team);
        for (int i = 0; i < teamDto.getListTeam().size(); i++) {
            teamDto.getListTeam().get(i).setTeam(team);
            Student student = teamDto.getListTeam().get(i);
         if (teamDto.getTeamLeader().equals(teamDto.getListTeam().get(i).getCode())){
             student.setGroupStatus(1.0);
         } else {
             student.setGroupStatus(0.5);
         }

            studentService.save(student);
            mailService.emailTeam(student, teamResponse);
        }
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @PostMapping("/deleteStudent")
    public ResponseEntity<Team> saveStudent(@RequestBody Student student) throws MessagingException {
        student.setTeam(teamService.findById(1L).orElse(null));
            studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listTeam")
    public ResponseEntity<List<Team>> listTeam() {
        List<Team> list = teamService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findTeam")
    public ResponseEntity<Team> findTeam(@RequestParam(value = "teamId") Long id) {
        Team team = teamService.findById(id).orElse(null);
        if (team==null) {
            return  new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @GetMapping("/disagree")
    @Transactional
    public ResponseEntity<Student> notagree(@RequestParam(value = "codeStudent") String codeStudent,
                                            HttpServletResponse response) throws IOException, MessagingException {
        Student student = studentService.findByCode(codeStudent);
        String mailTeamLeader = studentService.findByCode(student.getTeam().getTeamLeader()).getEmail();
        student.setTeam(teamService.findById(1L).orElse(null));
        studentService.save(student);
        mailService.emailCcTeamLeader(student,"t??? ch???i",mailTeamLeader);
        response.sendRedirect("http://localhost:4200/nhom/dang-ky/");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/agree")
    @Transactional
    public ResponseEntity<Student> agree(@RequestParam(value = "codeStudent") String codeStudent,
                                         @RequestParam(value = "teamId") Long teamId,
                                            HttpServletResponse response) throws IOException, MessagingException {
        Student student = studentService.findByCode(codeStudent);


        student.setTeam(teamService.findById(teamId).orElse(null));
        student.setGroupStatus(1.0);
        studentService.save(student);
        mailService.emailCcTeamLeader(student, "?????ng ??", studentService.findByCode( teamService.findById(teamId).orElse(null).getTeamLeader()).getEmail());
        response.sendRedirect("http://localhost:4200/nhom/quan-ly-nhom/");
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    -----------------------------------------------------------------------------------------------

    @GetMapping("/project")
    public ResponseEntity<List<Project>> list() {
        List<Project> list = projectService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<Page<DtoTeam>> listTeam(Pageable pageable) {
        Page<DtoTeam> list = teamService.findAllTeam(pageable);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id) {
        Team team = teamService.findById(id).orElse(null);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id) throws MessagingException {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Team team =  teamService.findById(id).orElse(null);
        team.setEnable(false);
        teamService.save(team);
        String[] email = teamService.findStudentGroupById(id);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        boolean multipart = true;
        String url = "http://localhost:4200";
//---------------------------------------------------
//        Ph???n n??y l?? n???i dung Email nha anh em
        String htmlMsg = "<div style=\"text-align: center\">\n" +
                "    <img src=\"https://milemir.com/wp-content/uploads/2020/11/team.jpg\" alt=\"l???i h??nh ???nh\"><br><br>" +
                "<h3>Nh??m C???a b???n ???? b??? xo??</h3><br><br>" +
                "    <br><br><a href='" + url + "' style='display:inline-block;text-decoration:none;background-color: black;color:#ffffff;padding:13px;border:0px solid #76b900;font-family: Roboto, sans-serif' >V??? trang nh??m</a>\n" +
                "    <div style='height: 30px'> </div>\n" +
                "</div>";
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart, "utf-8");
        mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
        //        -------------------------------------------
//        Ph???n n??y l?? n??i m??nh mu???n g???i ?????n nha, c?? th??? d??ng m???ng String n???u mu???n g???i nhi???u ng?????i.
        helper.setTo(email);
        //        -------------------------------------
//        C??i n??y l?? cc nha, c??ng c?? th??? cc m???ng String
        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("Nh??m C???a b???n ???? b??? xo??");
        this.mailSender.send(mimeMessage);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/dto/{id}")
    public ResponseEntity<DtoTeam> findByIdTeam(@PathVariable Long id) {
        DtoTeam team = teamService.findByIdTeam(id);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
    @GetMapping("/student")
    public void findGroupById(@RequestParam(value = "id") Long id, @RequestParam(value = "date") String date) throws MessagingException {
        String[] students = teamService.findStudentGroupById(id);
        String url = "http://localhost:4200/nhom/quan-ly-nhom";
        System.out.println("mealalalalalal" + students);
        //---T???o email ????n gi???n ---------//
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        boolean multipart = true;
//----------------------------------------------------------------//
        //-----N???i dung th??--------
        String htmlMsg =
                "<div style=\"text-align: center\">\n" +
                        "    <img src=\"https://milemir.com/wp-content/uploads/2020/11/team.jpg\" alt=\"l???i h??nh ???nh\"><br><br>" +
                        "<h3>H???n Ch??t N???p D??? ??n</h3><br><br>" +
                        "H???n ch??t n???p d??? ??n l?? :" + date +
                        "    <br><br><a href='" + url + "' style='display:inline-block;text-decoration:none;background-color: black;color:#ffffff;padding:13px;border:0px solid #76b900;font-family: Roboto, sans-serif' >V??? trang nh??m</a>\n" +
                        "    <div style='height: 30px'> </div>\n" +
                        "</div>";
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart, "utf-8");
        mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
        //-----Ng?????i nh???n (M???ng string)----
        helper.setTo(students);
        //-------CC------
        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("H???n ch??t n???p d??? ??n");
        this.mailSender.send(mimeMessage);
    }
    @GetMapping("/search")
    public ResponseEntity<List<DtoTeam>> searchAll(@RequestParam(value = "search", defaultValue = "") String search) {
        List<DtoTeam> list = teamService.searchAll(search);
        if (list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }


}