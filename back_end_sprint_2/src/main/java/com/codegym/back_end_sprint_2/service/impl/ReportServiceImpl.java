package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.ReportProgress;
import com.codegym.back_end_sprint_2.repositories.IReportRepository;
import com.codegym.back_end_sprint_2.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    private IReportRepository iReportRepository;

    @Override
    public ReportProgress save(ReportProgress reportProgress) {
        return iReportRepository.save(reportProgress);
    }

    @Override
    public List<ReportProgress> findAll() {
        return iReportRepository.findAll();
    }
}
