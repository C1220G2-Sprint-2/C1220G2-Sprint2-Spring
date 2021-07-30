package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.HistoryDto;
import com.codegym.back_end_sprint_2.model.dto.ReportDto;
import com.codegym.back_end_sprint_2.model.entities.ReportHistory;
import com.codegym.back_end_sprint_2.model.entities.ReportProgress;
import com.codegym.back_end_sprint_2.repositories.IReportHistoryRepository;
import com.codegym.back_end_sprint_2.repositories.IReportRepository;
import com.codegym.back_end_sprint_2.repositories.IStudentRepository;
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
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public ReportProgress save(ReportProgress reportProgress) {
        historyRepository.save(new ReportHistory(studentRepository.findByCode(reportProgress.getUser().getUsername()).getCode(),
                studentRepository.findByCode(reportProgress.getUser().getUsername()).getName(),
                reportProgress.getContent(), reportProgress.getDateCreate(), iReportRepository.findById(reportProgress.getId()).orElse(null), reportProgress.getFileReport()));

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

    @Override
    public List<HistoryDto> findAllReportHistory() {
        List<HistoryDto> historyDtos = new ArrayList<>();
        List<ReportHistory> reportHistories = historyRepository.findAll();
        for (ReportHistory reportHistory : reportHistories) {
            historyDtos.add(new HistoryDto(reportHistory.getId(), reportHistory.getNameUser(), reportHistory.getName(), reportHistory.getContent(), reportHistory.getDateCreate(),
                    studentRepository.findByCode(reportHistory.getNameUser()).getImage(), reportHistory.getFileReport()));
        }
        return historyDtos;
    }

    @Override
    public List<ReportHistory> findAllReportHistoryByReportId(Long id) {
        return historyRepository.findAllByReportProgressId(id);
    }


}
