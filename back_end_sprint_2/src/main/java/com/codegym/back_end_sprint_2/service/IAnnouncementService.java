package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementDto;
import com.codegym.back_end_sprint_2.model.entities.Announcement;

import java.util.List;

public interface IAnnouncementService {

    List<AnnouncementDto> findAll();

    void save(String attachFile, String content, String title, String teacherCode,Byte enable);
}
