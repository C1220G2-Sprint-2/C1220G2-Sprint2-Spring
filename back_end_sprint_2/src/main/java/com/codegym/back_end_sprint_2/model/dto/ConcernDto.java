package com.codegym.back_end_sprint_2.model.dto;

public class ConcernDto {

    private Long id;
    private String attachFile;
    private String content;
    private Byte enable;
    private String title;
    private Long notificationId;
    private String studentCode;
    private String teacherCode;

    public ConcernDto(Long id, String attachFile, String content, Byte enable, String title, Long notificationId, String studentCode, String teacherCode) {
        this.id = id;
        this.attachFile = attachFile;
        this.content = content;
        this.enable = enable;
        this.title = title;
        this.notificationId = notificationId;
        this.studentCode = studentCode;
        this.teacherCode = teacherCode;
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

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }
}
