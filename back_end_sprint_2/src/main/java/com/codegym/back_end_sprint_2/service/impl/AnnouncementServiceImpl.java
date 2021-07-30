package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementDto;
import com.codegym.back_end_sprint_2.model.entities.Announcement;
import com.codegym.back_end_sprint_2.repositories.IAnnouncementRepository;
import com.codegym.back_end_sprint_2.repositories.ITeacherRepository;
import com.codegym.back_end_sprint_2.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

    @Autowired
    private IAnnouncementRepository announcementRepository;
    @Autowired
    private ITeacherRepository teacherRepository;

//    @Override
//    public List<AnnouncementDto> findAll() {
//        List<AnnouncementDto> announcementDtoList = new ArrayList<>();
//        List<Announcement> announcementList = announcementRepository.findAll();
//        for (Announcement announcement : announcementList) {
//            announcementDtoList.add(new AnnouncementDto(announcement.getId(),announcement.getTitle(),
//                    announcement.getContent(),announcement.getTeacher().getCode(),announcement.getAvatar(),
//                    announcement.getName(),announcement.getAttachFile(), LocalDateTime.now()));
//        }
//        return announcementDtoList;
//    }

    @Override
    public List<AnnouncementDto> findAll(Long noOfPage) {
        List<AnnouncementDto> announcementDtoList = new ArrayList<>();
        List<Announcement> announcementList = announcementRepository.findAllByOrderByDateCreateDesc();
        int length = 0;
        for (Announcement announcement : announcementList) {
            if (length == noOfPage) {
                break;
            }
            announcementDtoList.add(new AnnouncementDto(announcement.getId(),announcement.getTitle(),
                    announcement.getContent(),announcement.getTeacher().getCode(),announcement.getAvatar(),
                    announcement.getName(),announcement.getAttachFile(), announcement.getDateCreate()));
            length++;
        }
        return announcementDtoList;
    }

//    @Override
//    public void save(String attachFile, String content, String title, String teacherCode, String avatar, String name, Byte enable) {
//        announcementRepository.saveAnnouncement(attachFile,content,title,teacherCode,avatar,name,enable);
//    }

    @Override
    public void save(AnnouncementDto announcementDto) {
        announcementRepository.save(new Announcement(announcementDto.getTitle(),announcementDto.getContent(),announcementDto.getAttachFile(),true,
                announcementDto.getAvatar(),announcementDto.getName(),LocalDateTime.now(),teacherRepository.findByCode(announcementDto.getTeacherCode())));
    }

    @Override
    public int maxLengthListReview() {
        return announcementRepository.findAll().size();
    }
}
