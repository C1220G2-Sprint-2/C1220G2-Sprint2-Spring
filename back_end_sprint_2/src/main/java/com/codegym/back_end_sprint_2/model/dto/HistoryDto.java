package com.codegym.back_end_sprint_2.model.dto;

import java.time.LocalDateTime;

public class HistoryDto {
    private Long id;

    private String nameUser;
    private String name;
    private String content;
    private LocalDateTime dateCreate;
    private String avatar;
    private String fileReport;

    public HistoryDto() {
    }

    public HistoryDto(Long id, String nameUser, String name, String content, LocalDateTime dateCreate, String avatar, String fileReport) {
        this.id = id;
        this.nameUser = nameUser;
        this.name = name;
        this.content = content;
        this.dateCreate = dateCreate;
        this.avatar = avatar;
        this.fileReport = fileReport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
