package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Announcement;
import com.codegym.back_end_sprint_2.repositories.IAnnouncementRepository;
import com.codegym.back_end_sprint_2.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

    @Autowired
    private IAnnouncementRepository announcementRepository;

    @Override
    public Page<Announcement> findAll(Pageable pageable) {
        return announcementRepository.findAllAnnouncement(pageable);
    }

    @Override
    public void save(String attachFile, String content, String title, Long notificationId, String teacherCode, Byte enable) {
        announcementRepository.saveAnnouncement(attachFile,content,title,notificationId,teacherCode,enable);
    }
}
