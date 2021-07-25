package com.codegym.back_end_sprint_2.model.entities;

import javax.persistence.*;

@Entity
public class ConcernComment {
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
    @JoinColumn(name = "concern_id")
    private Concern concern;

    public ConcernComment() {
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

    public Concern getConcern() {
        return concern;
    }

    public void setConcern(Concern concern) {
        this.concern = concern;
    }
}
