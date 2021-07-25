package com.codegym.back_end_sprint_2.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String attachFile;
    private boolean enable;
    private Integer progressReview;
    //code from sang
    private LocalDateTime dateCreate;
    //end code from sang
    @ManyToOne
    @JoinColumn(name = "teacher_code")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;

    public Review() {
    }

    public Review(String title, String content, boolean enable, Integer progressReview, Teacher teacher, LocalDateTime dateCreate) {
        this.title = title;
        this.content = content;
        this.enable = enable;
        this.progressReview = progressReview;
        this.teacher = teacher;
        this.dateCreate = dateCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(String attachFile) {
        this.attachFile = attachFile;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Integer getProgressReview() {
        return progressReview;
    }

    public void setProgressReview(Integer progressReview) {
        this.progressReview = progressReview;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}
