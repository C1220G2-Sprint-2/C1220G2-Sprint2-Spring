package com.codegym.back_end_sprint_2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDto {

    @Id
    private String code;
    private String name;
    private String phone;
    @Column(name = "classStudent")
    private String classStudent;
    private String email;
    private String image;
    private String faculty;
    private String facebook;
    private String address;
    private String dateOfBirth;
    private String gender;
    private String team;
    private boolean status;
    private boolean enable;


    public StudentDto() {
    }

    public StudentDto(String code, String name, String phone, String classStudent, String email, String image, String faculty, String facebook, boolean status) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.classStudent = classStudent;
        this.email = email;
        this.image = image;
        this.faculty = faculty;
        this.facebook = facebook;
        this.status = status;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
