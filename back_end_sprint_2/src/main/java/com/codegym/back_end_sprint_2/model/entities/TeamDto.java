package com.codegym.back_end_sprint_2.model.entities;

import java.util.List;

public class TeamDto {
    private Long id;
    private String name;
    private String teamLeader;
    private boolean enable;
    private List<Student> listTeam;

    public TeamDto() {
    }

    public TeamDto(Long id, String name, String teamLeader, boolean enable, List<Student> listTeam) {
        this.id = id;
        this.name = name;
        this.teamLeader = teamLeader;
        this.enable = enable;
        this.listTeam = listTeam;
    }

    public TeamDto(String name, String teamLeader, boolean enable, List<Student> listTeam) {
        this.name = name;
        this.teamLeader = teamLeader;
        this.enable = enable;
        this.listTeam = listTeam;
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

    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Student> getListTeam() {
        return listTeam;
    }

    public void setListTeam(List<Student> listTeam) {
        this.listTeam = listTeam;
    }
}
