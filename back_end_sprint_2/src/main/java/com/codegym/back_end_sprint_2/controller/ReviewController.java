package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.ReviewDto;
import com.codegym.back_end_sprint_2.model.entities.Progress;
import com.codegym.back_end_sprint_2.model.entities.Review;
import com.codegym.back_end_sprint_2.service.IProgressService;
import com.codegym.back_end_sprint_2.service.IProjectService;
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
    @Autowired
    private IProgressService progressService;

    @PostMapping("/review-save/{projectId}")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto, @PathVariable("projectId") int projectId) {
        try {
            Progress progress = progressService.findByStatus(projectId);
            Progress progressNext = progressService.findById(progress.getId() + 1);
            progress.setStage(reviewDto.getProgressReview());
            if (reviewDto.getProgressReview() == 100) {
                progress.setStatus("Hoàn thành");
                progressNext.setEnable(true);
                progressNext.setStatus("Đang tiến hành");
            }
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

    @GetMapping("/get-progress/{projectId}")
    public ResponseEntity<?> getProgress(@PathVariable("projectId") int projectId) {
        try {
            return new ResponseEntity<>(progressService.findByStatus(projectId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
