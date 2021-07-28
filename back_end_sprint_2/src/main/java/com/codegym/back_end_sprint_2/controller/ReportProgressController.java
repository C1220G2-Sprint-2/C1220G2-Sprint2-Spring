package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.entities.ReportProgress;
import com.codegym.back_end_sprint_2.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/report")
public class ReportProgressController {
    @Autowired
    private IReportService reportService;

    @GetMapping("/list")
    public ResponseEntity<List<ReportProgress>> getAll() {
        List<ReportProgress> reportProgressList = reportService.findAll();
        if (reportProgressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReportProgress> createReport(@RequestBody ReportProgress reportProgress) {
        reportService.save(reportProgress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
