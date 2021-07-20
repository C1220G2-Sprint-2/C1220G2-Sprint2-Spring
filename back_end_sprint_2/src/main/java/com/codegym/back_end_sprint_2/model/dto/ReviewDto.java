package com.codegym.back_end_sprint_2.model.dto;

import java.time.LocalDateTime;

public class ReviewDto {
    private Long id;
    private String title;
    private String content;
    private String attachFile;
    private boolean enable;
    private Integer progressReview;
    private String teacherCode;
    private Long notification;

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

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public Long getNotification() {
        return notification;
    }

    public void setNotification(Long notification) {
        this.notification = notification;
    }
}
