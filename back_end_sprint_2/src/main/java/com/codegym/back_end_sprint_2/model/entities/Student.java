package com.codegym.back_end_sprint_2.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GenericGenerator(name = "sequence_cus_id", strategy = "com.codegym.back_end_sprint_2.ulti.StudentIdGenerator")
    @GeneratedValue(generator = "sequence_cus_id")
    private String code;
    private String name;
    private String phone;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String address;
    private String image;
    private String facebook;
    @JsonProperty("groupStatus")

    private Double groupStatus;
    private boolean enable;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    public Student() {
    }


    public Student(String code, String name, String phone, String gender, String dateOfBirth, String email, String address, String image, String facebook, Double groupStatus, boolean enable, boolean status, Team team, Faculty faculty, Class aClass) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.image = image;
        this.facebook = facebook;
        this.groupStatus = groupStatus;
        this.enable = enable;
        this.status = status;
        this.team = team;
        this.faculty = faculty;
        this.aClass = aClass;
    }


    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Double getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(Double groupStatus) {
        this.groupStatus = groupStatus;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}