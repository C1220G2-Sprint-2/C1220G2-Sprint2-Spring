package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.model.entities.TeamDto;
import com.codegym.back_end_sprint_2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/project")
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

}