package com.codegym.back_end_sprint_2.model.dto;

public class ConcernCommentDto {

    private Long id;
    private String content;
    private String attachFile;
    private String teacherCode;
    private String studentCode;
    private String avatar;
    private String name;
    private Long concernId;

    public ConcernCommentDto() {
    }

    public ConcernCommentDto(String content, String attachFile, String teacherCode, String studentCode, String avatar, String name, Long concernId) {
        this.content = content;
        this.attachFile = attachFile;
        this.teacherCode = teacherCode;
        this.studentCode = studentCode;
        this.avatar = avatar;
        this.name = name;
        this.concernId = concernId;
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

    public Long getConcernId() {
        return concernId;
    }

    public void setConcernId(Long concernId) {
        this.concernId = concernId;
    }
}
