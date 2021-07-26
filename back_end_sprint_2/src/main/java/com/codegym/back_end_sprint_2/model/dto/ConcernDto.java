package com.codegym.back_end_sprint_2.model.dto;

public class ConcernDto {

    private Long id;
    private String title;
    private String content;
    private String studentCode;
    private String attachFile;

    public ConcernDto() {
    }

    public ConcernDto(Long id, String title, String content, String studentCode, String attachFile) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.studentCode = studentCode;
        this.attachFile = attachFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(String attachFile) {
        this.attachFile = attachFile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
}
