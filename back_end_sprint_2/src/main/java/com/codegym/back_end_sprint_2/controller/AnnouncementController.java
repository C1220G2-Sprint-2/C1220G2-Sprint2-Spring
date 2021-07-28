package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementDto;
import com.codegym.back_end_sprint_2.model.dto.MessageResponse;
import com.codegym.back_end_sprint_2.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/api/announcement")
public class AnnouncementController {

    @Autowired
    private IAnnouncementService announcementService;

    @GetMapping("/announcement-list/{noOfRecord}")
    public ResponseEntity<List<AnnouncementDto>> getListAnnouncement(@PathVariable("noOfRecord") Long noOfRecord) {
        List<AnnouncementDto> announcementDtoList = announcementService.findAll(noOfRecord);
        if (announcementDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(announcementDtoList, HttpStatus.OK);
    }

    @PostMapping("/announcement-save")
    public ResponseEntity<MessageResponse> saveConcern(@RequestBody AnnouncementDto announcement) {
        try {
            announcementService.save(announcement);
            return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-size")
    public ResponseEntity<?> getMaxSizeReviewList() {
        try {
            return new ResponseEntity<>(announcementService.maxLengthListReview(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
