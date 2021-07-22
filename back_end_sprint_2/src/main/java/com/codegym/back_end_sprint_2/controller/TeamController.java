package com.codegym.back_end_sprint_2.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
  import org.springframework.web.bind.annotation.*;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.model.entities.TeamDto;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IProjectService projectService;
    @Autowired
    private ITeamService teamService;
    @Autowired
    private IMailService mailService;


    @PostMapping("/postTeam")
    public ResponseEntity<Team> save(@RequestBody TeamDto teamDto) throws MessagingException {
        Team team = teamService.teamMapping(teamDto);
        teamService.save(team);
        for (int i = 0; i < teamDto.getListTeam().size(); i++) {
            teamDto.getListTeam().get(i).setTeam(team);
            studentService.save(teamDto.getListTeam().get(i));
            mailService.emailTeam(teamDto.getListTeam().get(i), teamDto);
        }
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @GetMapping("/disagree")
    @Transactional
    public ResponseEntity<Student> notagree(@RequestParam(value = "codeStudent") String codeStudent,
                                            HttpServletResponse response) throws IOException, MessagingException {
        Student student = studentService.findByCode(codeStudent);
        student.setTeam(teamService.findById(1L).orElse(null));
        studentService.save(student);
        mailService.emailCcTeamLeader(student,"từ chối");
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
        mailService.emailCcTeamLeader(student,"đồng ý");
        response.sendRedirect("http://localhost:4200/nhom/dang-ky/");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/searchTeamRegistration")
    public ResponseEntity<List<Student>> searchTeamRegistration(
            @RequestParam(value = "search", defaultValue = "") String search
    ) {

        List<Student> list = teamService.searchTeamRegistration(search);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
  
     @GetMapping("/project")
    public ResponseEntity<List<Project>> list() {
        List<Project> list = projectService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<Team>> listTeam() {
        List<Team> list = teamService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

}