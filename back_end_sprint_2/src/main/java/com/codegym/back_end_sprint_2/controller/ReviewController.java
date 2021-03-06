package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.ReviewDto;
import com.codegym.back_end_sprint_2.model.entities.Review;
import com.codegym.back_end_sprint_2.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    private IReviewService reviewService;

    @PostMapping("/review-save")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
        try {
            reviewService.save(reviewDto);
            return new ResponseEntity<>(reviewDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/review-list")
    public ResponseEntity<List<ReviewDto>> findAllReview() {
        try {
            return new ResponseEntity<>(reviewService.findAllReviewDto(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/review-list/{noOfRecord}")
    public ResponseEntity<List<ReviewDto>> findAllReview(@PathVariable("noOfRecord") Long noOfRecord) {
        try {
            System.out.println("da vao day" + reviewService.findAllReviewDto(noOfRecord).toString());
            return new ResponseEntity<>(reviewService.findAllReviewDto(noOfRecord), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/review-list-size")
    public ResponseEntity<?> getMaxSizeReviewList() {
        try {
            return new ResponseEntity<>(reviewService.maxLengthListReview(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
