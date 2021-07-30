package com.codegym.back_end_sprint_2.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ReportHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameUser;
    private String name;
    private String content;
    private LocalDateTime dateCreate;


    @ManyToOne
    @JoinColumn(name = "report_progress_id")
    private ReportProgress reportProgress;

    public ReportHistory() {
    }

    public ReportHistory( String nameUser, String name, String content, LocalDateTime dateCreate, ReportProgress reportProgress) {
        this.nameUser = nameUser;
        this.name = name;
        this.content = content;
        this.dateCreate = dateCreate;
        this.reportProgress = reportProgress;
    }

    public String getName() {
        return name;
    }

    public ReportProgress getReportProgress() {
        return reportProgress;
    }


    public void setReportProgress(ReportProgress reportProgress) {
        this.reportProgress = reportProgress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}
