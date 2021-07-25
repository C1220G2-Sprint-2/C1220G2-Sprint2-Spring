package com.codegym.back_end_sprint_2.model.dto;

public class ReviewDto {
    private Long id;
    private String title;
    private String content;
    private Integer progressReview;
    private String teacherCode;

    public ReviewDto(Long id, String title, String content,Integer progressReview, String teacherCode) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.progressReview = progressReview;
        this.teacherCode = teacherCode;
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
}
