package com.codegym.back_end_sprint_2.model.dto;

import java.time.LocalDateTime;

public class ReportDto {
    private Long id;
    private String name;
    private Integer stage;
    private String fileReport;
    private String content;
    private LocalDateTime dateCreate;

    public ReportDto() {
    }

    public ReportDto(Long id, String name, Integer stage, String fileReport, String content, LocalDateTime dateCreate) {
        this.id = id;
        this.name = name;
        this.stage = stage;
        this.fileReport = fileReport;
        this.content = content;
        this.dateCreate = dateCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public String getFileReport() {
        return fileReport;
    }

    public void setFileReport(String fileReport) {
        this.fileReport = fileReport;
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
