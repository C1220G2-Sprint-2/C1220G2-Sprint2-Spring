package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.HistoryDto;
import com.codegym.back_end_sprint_2.model.dto.ReportDto;
import com.codegym.back_end_sprint_2.model.entities.ReportHistory;
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

    @GetMapping("/list-history")
    public ResponseEntity<List<HistoryDto>> getAllReportHistory() {
        return new ResponseEntity<>(reportService.findAllReportHistory(), HttpStatus.OK);
    }

    @GetMapping("/list-history/{id}")
    public ResponseEntity<List<ReportHistory>> getAllHistoryByReportId(@PathVariable Long id) {
        return new ResponseEntity<>(reportService.findAllReportHistoryByReportId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportProgress> updateReport(@PathVariable Long id, @RequestBody ReportDto reportDto) {
        ReportProgress reportProgress = reportService.findById(id);
        if (reportProgress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(reportDto);
        reportProgress.setStage(reportDto.getStage());
        reportProgress.setContent(reportDto.getContent());
        reportProgress.setFileReport(reportDto.getFileReport());
        System.out.println(reportProgress + "hello");
        reportService.save(reportProgress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ReportProgress findById(@PathVariable Long id) {
        return reportService.findById(id);
    }


}
