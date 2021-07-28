package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.ReviewCommentDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ICommentReviewService {

    List<ReviewCommentDto> findAll();

    void saveCommentReview(String content, String studentCode, String avatar, String name, Long reviewId, LocalDateTime dateCreate);
}
