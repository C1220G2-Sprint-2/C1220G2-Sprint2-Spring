package com.codegym.back_end_sprint_2.model.dto;
import java.time.LocalDateTime;
public class ReviewDto {
    private Long id;
    private String title;
    private String content;
    private Integer progressReview;
    private String teacherCode;
    private LocalDateTime dateCreate;
    private String teacherName;
    private String avatar;
    public ReviewDto(Long id, String title, String content, Integer progressReview, String teacherCode, LocalDateTime dateCreate, String teacherName, String avatar) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.progressReview = progressReview;
        this.teacherCode = teacherCode;
        this.dateCreate = dateCreate;
        this.teacherName = teacherName;
        this.avatar = avatar;
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
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}