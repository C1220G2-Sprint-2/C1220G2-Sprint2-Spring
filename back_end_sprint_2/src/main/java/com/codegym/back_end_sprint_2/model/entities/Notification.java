package com.codegym.back_end_sprint_2.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ReportProgress> reportProgresses;
    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;
    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Concern> concerns;
    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Announcement> announcements;

    public Notification() {
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

    public List<ReportProgress> getReportProgresses() {
        return reportProgresses;
    }

    public void setReportProgresses(List<ReportProgress> reportProgresses) {
        this.reportProgresses = reportProgresses;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Concern> getConcerns() {
        return concerns;
    }

    public void setConcerns(List<Concern> concerns) {
        this.concerns = concerns;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }
}
