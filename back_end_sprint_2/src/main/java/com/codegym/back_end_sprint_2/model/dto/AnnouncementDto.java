package com.codegym.back_end_sprint_2.model.dto;

import java.time.LocalDateTime;

public class AnnouncementDto {

    private Long id;
    private String title;
    private String content;
    private String teacherCode;
    private String attachFile;
    private String avatar;
    private String name;
    private Byte enable;
    private LocalDateTime dateCreate;

    public AnnouncementDto() {
    }

    public AnnouncementDto(Long id, String title, String content, String teacherCode, String avatar, String name, String attachFile, LocalDateTime dateCreate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.teacherCode = teacherCode;
        this.attachFile = attachFile;
        this.avatar = avatar;
        this.name = name;
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

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}