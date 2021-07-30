package com.codegym.back_end_sprint_2.model.dto;

import java.time.LocalDateTime;

public class AnnouncementCommentDto {

    private Long id;
    private String content;
    private String attachFile;
    private String teacherCode;
    private String studentCode;
    private String avatar;
    private String name;
    private Long announcementId;
    private LocalDateTime dateCreate;

    public AnnouncementCommentDto() {
    }

    public AnnouncementCommentDto(String content, String attachFile, String teacherCode, String studentCode, String avatar, String name, Long announcementId, LocalDateTime dateCreate) {
        this.content = content;
        this.attachFile = attachFile;
        this.teacherCode = teacherCode;
        this.studentCode = studentCode;
        this.avatar = avatar;
        this.name = name;
        this.announcementId = announcementId;
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

    public String getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(String attachFile) {
        this.attachFile = attachFile;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
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

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}
