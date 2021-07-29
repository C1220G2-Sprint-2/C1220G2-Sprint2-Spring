package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.ReviewCommentDto;

import java.util.List;

public interface ICommentReviewService {

    List<ReviewCommentDto> findAll();

    void saveCommentReview(ReviewCommentDto reviewCommentDto);
}
