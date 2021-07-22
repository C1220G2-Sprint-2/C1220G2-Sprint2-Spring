package com.codegym.back_end_sprint_2.model.entities;

public class ProjectDtoHuy {
    private Long id;
    private String name;
    private String content;
    private String description;
    private String image;
    private String category;
    private String teacher;
    private Team team;

    public ProjectDtoHuy() {
    }

    public ProjectDtoHuy(String name, String content, String description, String image, String category, String teacher, Team team) {
        this.name = name;
        this.content = content;
        this.description = description;
        this.image = image;
        this.category = category;
        this.teacher = teacher;
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
