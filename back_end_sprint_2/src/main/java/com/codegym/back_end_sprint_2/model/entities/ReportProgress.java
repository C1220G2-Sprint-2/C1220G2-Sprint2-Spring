package com.codegym.back_end_sprint_2.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ReportProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer stage;
    private String fileReport;
    private String content;
    private boolean enable;
    private LocalDateTime dateCreate;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "reportProgress", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ReportHistory> reportHistories;

    public ReportProgress() {
    }

    public List<ReportHistory> getReportHistories() {
        return reportHistories;
    }

    public void setReportHistories(List<ReportHistory> reportHistories) {
        this.reportHistories = reportHistories;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ReportProgress{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stage=" + stage +
                ", fileReport='" + fileReport + '\'' +
                ", content='" + content + '\'' +
                ", enable=" + enable +
                ", dateCreate=" + dateCreate +
                ", project=" + project +
                ", notification=" + notification +
                ", user=" + user +
                ", reportHistories=" + reportHistories +
                '}';
    }
}
