package com.codegym.back_end_sprint_2.model.dto;

import java.time.LocalDateTime;

public class ReviewDto {
    private String title;
    private String content;
    private Integer progressReview;
    private String teacherCode;
    private LocalDateTime dateCreate;

    public ReviewDto(String title, String content, Integer progressReview, String teacherCode, LocalDateTime dateCreate) {
        this.title = title;
        this.content = content;
        this.progressReview = progressReview;
        this.teacherCode = teacherCode;
        this.dateCreate = dateCreate;
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

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}
