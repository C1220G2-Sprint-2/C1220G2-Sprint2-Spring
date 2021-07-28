package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementDto;
import com.codegym.back_end_sprint_2.model.dto.ConcernDto;
import com.codegym.back_end_sprint_2.model.entities.Announcement;
import com.codegym.back_end_sprint_2.model.entities.Concern;
import com.codegym.back_end_sprint_2.repositories.IAnnouncementRepository;
import com.codegym.back_end_sprint_2.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

    @Autowired
    private IAnnouncementRepository announcementRepository;

    @Override
    public List<AnnouncementDto> findAll() {
        List<AnnouncementDto> announcementDtoList = new ArrayList<>();
        List<Announcement> announcementList = announcementRepository.findAll();
        for (Announcement announcement : announcementList) {
            announcementDtoList.add(new AnnouncementDto(announcement.getId(),announcement.getTitle(),
                    announcement.getContent(),announcement.getTeacher().getCode(),announcement.getAvatar(),
                    announcement.getName(),announcement.getAttachFile()));
        }
        return announcementDtoList;
    }

    @Override
    public void save(String attachFile, String content, String title, String teacherCode, String avatar, String name, Byte enable) {
        announcementRepository.saveAnnouncement(attachFile,content,title,teacherCode,avatar,name,enable);
    }
}
