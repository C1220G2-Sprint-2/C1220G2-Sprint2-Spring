package com.codegym.back_end_sprint_2.model.dto;

public class AnnouncementDto {

    private Long id;
    private String title;
    private String content;
    private String teacherCode;
    private String attachFile;
    private Byte enable;


    public AnnouncementDto() {
    }

    public AnnouncementDto(Long id, String title, String content, String teacherCode, String attachFile) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.teacherCode = teacherCode;
        this.attachFile = attachFile;
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

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(String attachFile) {
        this.attachFile = attachFile;
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }
}