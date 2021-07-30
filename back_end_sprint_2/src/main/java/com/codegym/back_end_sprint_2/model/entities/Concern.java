package com.codegym.back_end_sprint_2.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Concern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "Mediumtext")
    private String content;
    private String attachFile;
    private boolean enable;
    private String avatar;
    private String name;
    private LocalDateTime dateCreate;
    @ManyToOne
    @JoinColumn(name = "student_code")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;
    @ManyToOne
    @JoinColumn(name = "teacher_code")
    private Teacher teacher;

    public Concern() {
    }

    public Concern(String title, String content, String attachFile, boolean enable, String avatar, String name,
                   LocalDateTime dateCreate, Student student) {
        this.title = title;
        this.content = content;
        this.attachFile = attachFile;
        this.enable = enable;
        this.avatar = avatar;
        this.name = name;
        this.dateCreate = dateCreate;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(String attachFile) {
        this.attachFile = attachFile;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}
