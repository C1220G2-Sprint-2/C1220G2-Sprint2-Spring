package com.codegym.back_end_sprint_2.model.dto;

import java.time.LocalDateTime;

public class PhaseDto {
    private Long id;
    private String name;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private String status;
    private int stage;
    private boolean isEnable;
    private int projectId;
    private String backgroundColor;
    private String colorStatus;

    public PhaseDto(Long id, String name, LocalDateTime dateStart, LocalDateTime dateEnd, String status, int stage, boolean isEnable, int projectId) {
        this.id = id;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.status = status;
        this.stage = stage;
        this.isEnable = isEnable;
        this.projectId = projectId;
        if (this.stage <= 25) {
            this.backgroundColor = "red";
        } else if (this.stage <= 80) {
            this.backgroundColor = "blue";
        } else {
            this.backgroundColor = "green";
        }
        switch (this.status) {
            case "Đang tiến hành":
                this.colorStatus = "blue";
                break;
            case "Chưa mở":
                this.colorStatus = "gray";
                break;
            case "Hoàn thành":
                this.colorStatus = "green";
                break;
        }
    }

    public Long getId() {
        return id;
    }

    public String getColorStatus() {
        return colorStatus;
    }

    public void setColorStatus(String colorStatus) {
        this.colorStatus = colorStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
