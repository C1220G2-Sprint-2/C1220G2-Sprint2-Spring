package com.codegym.back_end_sprint_2.model.dto;

import com.codegym.back_end_sprint_2.model.entities.Concern;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConcernDto {

    private Long id;
    private String title;
    private String content;
    private String studentCode;
    private String attachFile;
    private String avatar;
    private String name;
    private LocalDateTime dateCreate;
    private Long projectId;

    public ConcernDto() {
    }

    public ConcernDto(Long id, String title, String content,
                      String studentCode, String attachFile, String avatar, String name, LocalDateTime dateCreate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.studentCode = studentCode;
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

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
