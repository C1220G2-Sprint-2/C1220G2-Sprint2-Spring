package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.ReportHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportHistoryRepository extends JpaRepository<ReportHistory, Long> {
    List<ReportHistory> findAllByReportProgressId(Long id);
}
