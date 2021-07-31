package com.codegym.back_end_sprint_2.model.dto;

public class ProjectDto {
    private Long id;
    private String name;
    private String teamName;
    private String teacherName;

    public ProjectDto(Long id, String name, String teamName, String teacherName) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.teacherName = teacherName;
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

    public String getTeamName() {
        return teamName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
