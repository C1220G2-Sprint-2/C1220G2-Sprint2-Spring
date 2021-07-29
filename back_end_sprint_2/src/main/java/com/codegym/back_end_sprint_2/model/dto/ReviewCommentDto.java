package com.codegym.back_end_sprint_2.model.dto;

import java.time.LocalDateTime;

public class ReviewCommentDto {

    private Long id;
    private String content;
    private String studentCode;
    private String avatar;
    private String name;
    private Long reviewId;
    private LocalDateTime dateCreate;

    public ReviewCommentDto() {
    }

    public ReviewCommentDto(Long id, String content, String studentCode, String avatar, String name, Long reviewId, LocalDateTime dateCreate) {
        this.id = id;
        this.content = content;
        this.studentCode = studentCode;
        this.avatar = avatar;
        this.name = name;
        this.reviewId = reviewId;
        this.dateCreate = dateCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}
