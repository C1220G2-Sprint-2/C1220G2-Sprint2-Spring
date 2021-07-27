package com.codegym.back_end_sprint_2.model.dto;

public class ProgressDto {
    private String team;
    private String projectName;
    private int member;

    public ProgressDto() {
    }

    public ProgressDto(String team, String projectName, int member) {
        this.team = team;
        this.projectName = projectName;
        this.member = member;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "ProgressDto{" +
                "team='" + team + '\'' +
                ", projectName='" + projectName + '\'' +
                ", member=" + member +
                '}';
    }
}
