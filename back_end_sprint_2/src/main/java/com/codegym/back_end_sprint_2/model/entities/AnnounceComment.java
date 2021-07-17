package com.codegym.back_end_sprint_2.model.entities;

import javax.persistence.*;

@Entity
public class AnnounceComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "teacher_code")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "student_code")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "announcement_id")
    private Announcement announcement;

    public AnnounceComment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }
}
