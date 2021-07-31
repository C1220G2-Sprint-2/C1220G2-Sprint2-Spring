package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.*;
import com.codegym.back_end_sprint_2.model.entities.Progress;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Teacher;
import com.codegym.back_end_sprint_2.service.IProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/progress")
public class ProgressController {
    @Autowired
    private IProgressService progressService;

    @GetMapping("/list")
    public ResponseEntity<List<ProgressDto>> findAllProgress() {
        try {
            return new ResponseEntity<>(progressService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student-list-of-group/{projectId}")
    public ResponseEntity<List<ProgressStudentDto>> findAllStudentOfGroup(@PathVariable("projectId") Long projectId) {
        try {
            return new ResponseEntity<>(progressService.findStudentByIdGroup(projectId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<ProjectDto> findProjectById(@PathVariable("projectId") Long projectId) {
        try {
            System.out.println(projectId);
            return new ResponseEntity<>(progressService.findProjectDtoByID(projectId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find-teacher/{code}")
    public ResponseEntity<Teacher> findTeacherByCode(@PathVariable("code") String code) {
        try {
            System.out.println(code);
            return new ResponseEntity<>(progressService.findTeacherByCode(code), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProgressDto>> searchProgress(@RequestParam("projectName") String name) {
        try {
            return new ResponseEntity<>(progressService.searchByName(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-progress/{projectId}")
    public ResponseEntity<List<PhaseDto>> getProgressOfProject(@PathVariable("projectId") int projectId) {
        try {
            return new ResponseEntity<>(progressService.findProgressByProject(projectId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
