package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementCommentDto;
import com.codegym.back_end_sprint_2.model.dto.ConcernCommentDto;
import com.codegym.back_end_sprint_2.model.dto.ConcernDto;
import com.codegym.back_end_sprint_2.model.entities.Concern;
import com.codegym.back_end_sprint_2.model.entities.ConcernComment;
import com.codegym.back_end_sprint_2.repositories.ICommentConcernRepository;
import com.codegym.back_end_sprint_2.repositories.IStudentRepository;
import com.codegym.back_end_sprint_2.repositories.ITeacherRepository;
import com.codegym.back_end_sprint_2.service.ICommentConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentConcernServiceImpl implements ICommentConcernService {

    @Autowired
    private ICommentConcernRepository commentConcernRepository;

    @Override
    public List<ConcernCommentDto> findAll() {
        List<ConcernCommentDto> concernCommentDtoList = new ArrayList<>();
        List<ConcernComment> concernCommentList = commentConcernRepository.findAll();
        for (ConcernComment concernComment : concernCommentList) {
            concernCommentDtoList.add(new ConcernCommentDto(concernComment.getContent(),concernComment.getAttachFile(),concernComment.getTeacherCode(),
                    concernComment.getStudentCode(),concernComment.getAvatar(),concernComment.getName(),concernComment.getConcernId(),concernComment.getDateCreate()));
        }
        return concernCommentDtoList;
    }

    @Override
    public void saveCommentConcern(ConcernCommentDto concernCommentDto) {
        commentConcernRepository.save(new ConcernComment(concernCommentDto.getContent(),concernCommentDto.getAttachFile(),
                concernCommentDto.getAvatar(),concernCommentDto.getName(), concernCommentDto.getTeacherCode(),
                concernCommentDto.getStudentCode(),concernCommentDto.getConcernId(),LocalDateTime.now()));
    }

    @Override
    public String getStudentEmail(Long concernId) {
        return commentConcernRepository.getStudentEmail(concernId);
    }
}
