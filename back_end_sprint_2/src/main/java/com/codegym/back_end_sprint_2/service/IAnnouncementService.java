package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAnnouncementService {

    Page<Announcement> findAll(Pageable pageable);

    void save(String attachFile, String content, String title, Long notificationId, String teacherCode,Byte enable);
}
