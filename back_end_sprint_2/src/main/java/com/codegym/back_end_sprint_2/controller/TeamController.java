package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.service.IProjectService;
import com.codegym.back_end_sprint_2.service.ITeamService;
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
    ITeamService teamService;
    @Autowired
    IProjectService projectService;


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