package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.ReviewDto;
import com.codegym.back_end_sprint_2.model.entities.Notification;
import com.codegym.back_end_sprint_2.model.entities.Review;

import java.util.List;

public interface IReviewService {
    void save(ReviewDto reviewDto);

    Notification findNotificationById(Long id);

    List<ReviewDto> findAllReviewDto();

    List<ReviewDto> findAllReviewDto(Long noOfRecord);

    int maxLengthListReview();
}
