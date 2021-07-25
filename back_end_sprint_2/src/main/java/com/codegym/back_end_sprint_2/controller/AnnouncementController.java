package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementDto;
import com.codegym.back_end_sprint_2.model.dto.MessageResponse;
import com.codegym.back_end_sprint_2.model.entities.Announcement;
import com.codegym.back_end_sprint_2.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/api/concern")
public class AnnouncementController {

    @Autowired
    private IAnnouncementService announcementService;

    @GetMapping("/announcement-list")
    public ResponseEntity<Page<Announcement>> getListAnnouncement(Pageable pageable) {
        Page<Announcement> concernList = announcementService.findAll(pageable);
        if (concernList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(concernList, HttpStatus.OK);
    }

    @PostMapping("/announcement-create")
    public ResponseEntity<MessageResponse> saveConcern(@RequestBody AnnouncementDto announcement) {
        Byte announcementEnable = 1;
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setAttachFile(announcement.getAttachFile());
        announcementDto.setContent(announcement.getContent());
        announcementDto.setTitle(announcement.getTitle());
        announcementDto.setNotificationId(announcement.getNotificationId());
        announcementDto.setTeacherCode(announcement.getTeacherCode());
        announcementService.save(announcementDto.getAttachFile(), announcementDto.getContent(),
                announcementDto.getTitle(), announcementDto.getNotificationId(),
                announcementDto.getTeacherCode(),announcementEnable);
        return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
    }
}
