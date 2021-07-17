package com.codegym.back_end_sprint_2.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String attachFile;
    private boolean enable;
    @ManyToOne
    @JoinColumn(name = "teacher_code")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;
    @OneToMany(mappedBy = "announcement", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnnounceComment> announceComments;

    public Announcement() {
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public List<AnnounceComment> getAnnounceComments() {
        return announceComments;
    }

    public void setAnnounceComments(List<AnnounceComment> announceComments) {
        this.announceComments = announceComments;
    }
}
