package com.codegym.back_end_sprint_2.model.dto;

public class ProjectDto {
    private Long id;
    private String name;
    private String teamName;

    public ProjectDto(Long id, String name,String teamName) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
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

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
