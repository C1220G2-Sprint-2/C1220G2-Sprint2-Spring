package com.codegym.back_end_sprint_2.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teamLeader;
    private boolean enable;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonBackReference(value = "students")
    private List<Student> students;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonBackReference(value = "projects")
    private List<Project> projects;
    private Integer noOfMember;


    public Team() {
    }

    public Team(Long id, String name, String teamLeader, boolean enable, List<Student> students, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.teamLeader = teamLeader;
        this.enable = enable;
        this.students = students;
        this.projects = projects;
    }

    public Team(Long id, String name, String teamLeader, boolean enable) {
        this.id = id;
        this.name = name;
        this.teamLeader = teamLeader;
        this.enable = enable;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Integer getNoOfMember() {
        return noOfMember;
    }

    public void setNoOfMember(Integer noOfMember) {
        this.noOfMember = noOfMember;
    }

}
