package com.codegym.back_end_sprint_2.model.dto;

public class ProgressDto {
    private Long idProject;
    private String team;
    private String projectName;
    private String teacherName;
    private int member;

    public ProgressDto() {
    }

    public ProgressDto(String team, String projectName, int member) {
        this.team = team;
        this.projectName = projectName;
        this.member = member;
    }

    public ProgressDto(Long idProject, String team, String projectName, int member) {
        this.idProject = idProject;
        this.team = team;
        this.projectName = projectName;
        this.member = member;
    }

    public ProgressDto(Long idProject, String team, String projectName, String teacherName, int member) {
        this.idProject = idProject;
        this.team = team;
        this.projectName = projectName;
        this.teacherName = teacherName;
        this.member = member;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
