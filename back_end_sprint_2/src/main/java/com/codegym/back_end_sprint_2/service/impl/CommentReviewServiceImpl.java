package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.ConcernCommentDto;
import com.codegym.back_end_sprint_2.model.dto.ReviewCommentDto;
import com.codegym.back_end_sprint_2.model.entities.ConcernComment;
import com.codegym.back_end_sprint_2.model.entities.ReviewComment;
import com.codegym.back_end_sprint_2.repositories.ICommentReviewRepository;
import com.codegym.back_end_sprint_2.service.ICommentReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentReviewServiceImpl implements ICommentReviewService {

    @Autowired
    private ICommentReviewRepository commentReviewRepository;

    @Override
    public List<ReviewCommentDto> findAll() {
        List<ReviewCommentDto> reviewCommentDtoList = new ArrayList<>();
        List<ReviewComment> reviewCommentList = commentReviewRepository.findAll();
        for (ReviewComment reviewComment : reviewCommentList) {
            reviewCommentDtoList.add(new ReviewCommentDto(reviewComment.getId(),reviewComment.getContent(),reviewComment.getStudentCode(),
                    reviewComment.getAvatar(),reviewComment.getName(),reviewComment.getReviewId(),LocalDateTime.now()));
        }
        return reviewCommentDtoList;
    }

    @Override
    public void saveCommentReview(String content, String studentCode, String avatar, String name, Long reviewId, LocalDateTime dateCreate) {
        commentReviewRepository.saveReviewComment(content,studentCode,avatar,name,reviewId,dateCreate);
    }
}
