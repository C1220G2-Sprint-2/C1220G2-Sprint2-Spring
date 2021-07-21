package com.codegym.back_end_sprint_2.Dto;

public class DtoTeam {
    String name;
    String teamLeader;
    String deadline;
    String status;

    public DtoTeam(String name, String teamLeader, String deadline, String status) {
        this.name = name;
        this.teamLeader = teamLeader;
        this.deadline = deadline;
        this.status = status;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
