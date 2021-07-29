package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.ReportDto;
import com.codegym.back_end_sprint_2.model.entities.ReportHistory;
import com.codegym.back_end_sprint_2.model.entities.ReportProgress;
import com.codegym.back_end_sprint_2.repositories.IReportHistoryRepository;
import com.codegym.back_end_sprint_2.repositories.IReportRepository;
import com.codegym.back_end_sprint_2.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    private IReportRepository iReportRepository;
    @Autowired
    private IReportHistoryRepository historyRepository;

    @Override
    public ReportProgress save(ReportProgress reportProgress) {
        historyRepository.save(new ReportHistory(reportProgress.getUser().getUsername(),reportProgress.getContent(),reportProgress.getDateCreate()));
        return iReportRepository.save(reportProgress);
    }

    @Override
    public List<ReportDto> findAll() {
        List<ReportDto> reportDtoList = new ArrayList<>();
        List<ReportProgress> reportProgresses = iReportRepository.findAll();
        for (ReportProgress reportProgress : reportProgresses) {
            reportDtoList.add(new ReportDto(reportProgress.getId(), reportProgress.getName(), reportProgress.getStage(), reportProgress.getFileReport()
                    , reportProgress.getContent(), reportProgress.getDateCreate(), reportProgress.getProject().getId(), reportProgress.getUser().getId()));
        }
        return reportDtoList;
    }

    @Override
    public ReportProgress findById(Long id) {
        return iReportRepository.findById(id).orElse(null);
    }

    @Override
    public void updateReport(ReportProgress reportProgress) {
        iReportRepository.save(reportProgress);
    }


}
