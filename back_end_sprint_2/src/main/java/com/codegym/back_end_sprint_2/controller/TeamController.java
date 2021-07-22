package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.Dto.DtoTeam;
import com.codegym.back_end_sprint_2.config.MailConfig;
import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.service.IProjectService;
import com.codegym.back_end_sprint_2.service.IStudentService;
import com.codegym.back_end_sprint_2.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    ITeamService teamService;
    @Autowired
    IProjectService projectService;
    @Autowired
    private JavaMailSender mailSender;


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
        teamService.saveTeam(id);
        String[] email = teamService.findStudentGroupById(id);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        boolean multipart = true;
//---------------------------------------------------
//        Phần này là nội dung Email nha anh em
        String htmlMsg = "Nhóm của bạn Đã bị xoá";


        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart, "utf-8");
        mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");

        //        -------------------------------------------
//        Phần này là nơi mình muốn gửi đến nha, có thể dùng mảng String nếu muốn gửi nhiều người.
        helper.setTo(email);
        //        -------------------------------------
//        Cái này là cc nha, cũng có thể cc mảng String
        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("Nhóm Của bạn đã bị xoá");
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

    @GetMapping("/student/{id}")
    public void findGroupById(@PathVariable Long id) throws MessagingException {
        String[] students = teamService.findStudentGroupById(id);
        System.out.println("mealalalalalal" + students);
        //---Tạo email đơn giản ---------//
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        boolean multipart = true;
//----------------------------------------------------------------//
        //-----Nội dung thư--------
        String htmlMsg = "Hạn chót nộp dự án là ....";
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart, "utf-8");
        mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
        //-----Người nhận (Mảng string)----
        helper.setTo(students);
        //-------CC------
        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("Hạn chót nộp dự án");
        this.mailSender.send(mimeMessage);


    }


}