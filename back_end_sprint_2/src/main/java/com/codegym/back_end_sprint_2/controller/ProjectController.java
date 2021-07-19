package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.entities.*;
import com.codegym.back_end_sprint_2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/team")
public class ProjectController {

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

    @GetMapping("/listStudent")
    public ResponseEntity<List<Student>> listMeetingRoom() {
        List<Student> list = studentService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> listCategory() {
        List<Category> list = categoryService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/listTeacher")
    public ResponseEntity<List<Teacher>> listTeacher() {
        List<Teacher> list = teacherService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/listProject")
    public ResponseEntity<List<Project>> listProject() {
        List<Project> list = projectService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/postTeam")
    public ResponseEntity<Team> save(@RequestBody TeamDto teamDto) {
        Team team = teamService.teamMapping(teamDto);
        teamService.save(team);
        for (int i=0; i< teamDto.getListTeam().size();i++) {
            teamDto.getListTeam().get(i).setTeam(team);
            studentService.save(teamDto.getListTeam().get(i));
        }

        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }
}
