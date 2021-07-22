package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    IProjectService projectService;

    @GetMapping()
    public ResponseEntity<Page<Project>> getListProject(Pageable pageable) {
        Page<Project> projectPage = projectService.findAll(pageable);
        if (projectPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projectPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Project findById(@PathVariable Long id){
        return projectService.findById(id);
    }
    @PutMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestBody Project project) {
        projectService.delete(false, id);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Project>> getListProjectApprove(Pageable pageable) {
        Page<Project> projectPage1 = projectService.findAllApprove(pageable);
        if (projectPage1.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projectPage1, HttpStatus.OK);
    }

    @PutMapping("approve/{id}")
    public void approveProject(@PathVariable Long id, @RequestBody Project project) {
        projectService.approveProject(1, id);
    }

    @PutMapping("notApprove/{id}")
    public void notApproveProject(@PathVariable Long id, @RequestBody Project project) {
        projectService.notApproveProject(2, id);
    }
}