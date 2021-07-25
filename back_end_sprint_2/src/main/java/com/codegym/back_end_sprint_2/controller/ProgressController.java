package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.ProgressDto;
import com.codegym.back_end_sprint_2.model.dto.ProgressStudentDto;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.service.IProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/student-list")
    public ResponseEntity<List<ProgressStudentDto>> findAllStudent() {
        try {
            return new ResponseEntity<>(progressService.findAllStudent(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
