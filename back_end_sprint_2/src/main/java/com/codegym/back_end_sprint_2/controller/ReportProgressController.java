package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.ReportDto;
import com.codegym.back_end_sprint_2.model.entities.ReportProgress;
import com.codegym.back_end_sprint_2.repositories.IReportHistoryRepository;
import com.codegym.back_end_sprint_2.service.IReportService;
import com.codegym.back_end_sprint_2.service.IUserService;
import com.codegym.back_end_sprint_2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/report")
public class ReportProgressController {
    @Autowired
    private IReportService reportService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private IUserService userService;
    @Autowired
    IReportHistoryRepository historyRepository;

    @GetMapping("/list")
    public ResponseEntity<List<ReportDto>> getAll() {
        try {
            return new ResponseEntity<>(reportService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportProgress> updateReport(@PathVariable Long id, @RequestBody ReportDto reportDto) {
        ReportProgress reportProgress = reportService.findById(id);
        System.out.println(reportDto + "hello");
        if (reportProgress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        reportProgress.setId(id);
        reportProgress.setName(reportDto.getName());
        reportProgress.setStage(reportDto.getStage());
        reportProgress.setFileReport(reportDto.getFileReport());
        reportProgress.setContent(reportDto.getContent());
        reportProgress.setEnable(true);
        reportProgress.setDateCreate(LocalDateTime.now());
        reportProgress.setProject(projectService.findById(reportDto.getProjectId()));
        reportProgress.setUser(userService.findUserById(reportDto.getUserId()));
        reportService.save(reportProgress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ReportProgress findById(@PathVariable Long id) {
        return reportService.findById(id);
    }
}
