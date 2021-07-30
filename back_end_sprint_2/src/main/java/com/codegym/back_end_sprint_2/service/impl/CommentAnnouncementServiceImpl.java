package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementCommentDto;
import com.codegym.back_end_sprint_2.model.dto.ConcernCommentDto;
import com.codegym.back_end_sprint_2.model.entities.AnnounceComment;
import com.codegym.back_end_sprint_2.model.entities.ConcernComment;
import com.codegym.back_end_sprint_2.repositories.ICommentAnnouncementRepository;
import com.codegym.back_end_sprint_2.service.ICommentAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentAnnouncementServiceImpl implements ICommentAnnouncementService {

    @Autowired
    private ICommentAnnouncementRepository commentAnnouncementRepository;

    @Override
    public List<AnnouncementCommentDto> findAll() {
        List<AnnouncementCommentDto> announcementCommentDtoList = new ArrayList<>();
        List<AnnounceComment> announceCommentList = commentAnnouncementRepository.findAll();
        for (AnnounceComment announceComment : announceCommentList) {
            announcementCommentDtoList.add(new AnnouncementCommentDto(announceComment.getContent(),announceComment.getAttachFile(),announceComment.getTeacherCode(),
                    announceComment.getStudentCode(),announceComment.getAvatar(),announceComment.getName(),announceComment.getAnnouncementId(),announceComment.getDateCreate()));
        }
        return announcementCommentDtoList;
    }

    @Override
    public void saveCommentConcern(AnnouncementCommentDto announcementCommentDto) {
        commentAnnouncementRepository.save(new AnnounceComment(announcementCommentDto.getContent(),announcementCommentDto.getAttachFile(),
                announcementCommentDto.getAvatar(),announcementCommentDto.getName(),announcementCommentDto.getTeacherCode(),
                announcementCommentDto.getStudentCode(),announcementCommentDto.getAnnouncementId(),LocalDateTime.now()));
    }
}
