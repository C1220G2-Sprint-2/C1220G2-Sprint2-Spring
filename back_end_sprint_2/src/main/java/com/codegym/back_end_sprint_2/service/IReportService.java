package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.HistoryDto;
import com.codegym.back_end_sprint_2.model.dto.ReportDto;
import com.codegym.back_end_sprint_2.model.entities.ReportHistory;
import com.codegym.back_end_sprint_2.model.entities.ReportProgress;

import java.util.List;

public interface IReportService {
    ReportProgress save(ReportProgress reportProgress);

    List<ReportDto> findAll();

    ReportProgress findById(Long id);

    void updateReport(ReportProgress reportProgress);
    List<HistoryDto> findAllReportHistory();

    List<ReportHistory> findAllReportHistoryByReportId(Long id);
}
