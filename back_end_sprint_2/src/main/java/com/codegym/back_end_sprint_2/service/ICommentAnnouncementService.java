package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementCommentDto;

import java.util.List;

public interface ICommentAnnouncementService {

    List<AnnouncementCommentDto> findAll();

    void saveCommentConcern(String content, Long announcementId, String studentCode, String teacherCode,String attachFile,String avatar, String name);
}
