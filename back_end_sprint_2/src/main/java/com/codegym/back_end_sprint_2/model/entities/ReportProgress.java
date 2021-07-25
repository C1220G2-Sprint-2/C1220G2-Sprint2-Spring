package com.codegym.back_end_sprint_2.model.entities;

import javax.persistence.*;

@Entity
public class ReportProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer stages;
    private String fileReport;
    private String content;
    private boolean enable;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;

    public ReportProgress() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStages() {
        return stages;
    }

    public void setStages(Integer stages) {
        this.stages = stages;
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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
