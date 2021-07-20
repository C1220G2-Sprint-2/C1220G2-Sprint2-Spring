package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.ReviewDto;
import com.codegym.back_end_sprint_2.model.entities.Notification;
import com.codegym.back_end_sprint_2.model.entities.Review;
import com.codegym.back_end_sprint_2.repositories.INotificationRepository;
import com.codegym.back_end_sprint_2.repositories.IReviewRepository;
import com.codegym.back_end_sprint_2.repositories.ITeacherRepository;
import com.codegym.back_end_sprint_2.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService {
    @Autowired
    private IReviewRepository reviewRepository;
    @Autowired
    private ITeacherRepository teacherRepository;
    @Autowired
    private INotificationRepository notificationRepository;

    @Override
    public void save(ReviewDto reviewDto) {
        Review review = new Review(reviewDto.getTitle(), reviewDto.getContent(), reviewDto.getAttachFile(), reviewDto.isEnable(), reviewDto.getProgressReview(), teacherRepository.findByCode(reviewDto.getTeacherCode()), findNotificationById(reviewDto.getNotification()), LocalDateTime.now());
        reviewRepository.save(review);
    }

    @Override
    public Notification findNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }
}
