package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementCommentDto;
import com.codegym.back_end_sprint_2.model.dto.ConcernCommentDto;
import com.codegym.back_end_sprint_2.model.dto.ConcernDto;
import com.codegym.back_end_sprint_2.model.dto.MessageResponse;
import com.codegym.back_end_sprint_2.service.ICommentAnnouncementService;
import com.codegym.back_end_sprint_2.service.ICommentConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/api/comment")
public class CommentController {

    @Autowired
    private ICommentConcernService commentConcernService;
    @Autowired
    private ICommentAnnouncementService commentAnnouncementService;

    @GetMapping("/concern/comment-list")
    public ResponseEntity<List<ConcernCommentDto>> getListConcern() {
        List<ConcernCommentDto> concernCommentDtoList = commentConcernService.findAll();
        if (concernCommentDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(concernCommentDtoList, HttpStatus.OK);
    }

    @PostMapping("/concern/comment-save")
    public ResponseEntity<MessageResponse> saveConcern(@RequestBody ConcernCommentDto concernComment) {
        ConcernCommentDto concernCommentDto = new ConcernCommentDto();
        concernCommentDto.setContent(concernComment.getContent());
        concernCommentDto.setAttachFile(concernComment.getAttachFile());
        concernCommentDto.setTeacherCode(concernComment.getTeacherCode());
        concernCommentDto.setStudentCode(concernComment.getStudentCode());
        concernCommentDto.setAvatar(concernComment.getAvatar());
        concernCommentDto.setName(concernComment.getName());
        concernCommentDto.setConcernId(concernComment.getConcernId());
        commentConcernService.saveCommentConcern(concernCommentDto.getContent(),concernCommentDto.getConcernId(),concernCommentDto.getAttachFile(),
                concernCommentDto.getTeacherCode(),concernCommentDto.getStudentCode(),concernCommentDto.getAvatar(),
                concernCommentDto.getName());
        return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
    }

    @GetMapping("/announcement/comment-list")
    public ResponseEntity<List<AnnouncementCommentDto>> getListAnnouncement() {
        List<AnnouncementCommentDto> announcementCommentDtoList = commentAnnouncementService.findAll();
        if (announcementCommentDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(announcementCommentDtoList, HttpStatus.OK);
    }

    @PostMapping("/announcement/comment-save")
    public ResponseEntity<MessageResponse> saveAnnouncement(@RequestBody AnnouncementCommentDto announcementComment) {
        AnnouncementCommentDto announcementCommentDto = new AnnouncementCommentDto();
        announcementCommentDto.setContent(announcementComment.getContent());
        announcementCommentDto.setAttachFile(announcementComment.getAttachFile());
        announcementCommentDto.setTeacherCode(announcementComment.getTeacherCode());
        announcementCommentDto.setStudentCode(announcementComment.getStudentCode());
        announcementCommentDto.setAvatar(announcementComment.getAvatar());
        announcementCommentDto.setName(announcementComment.getName());
        announcementCommentDto.setAnnouncementId(announcementComment.getAnnouncementId());
        commentAnnouncementService.saveCommentConcern(announcementCommentDto.getContent(),announcementCommentDto.getAnnouncementId(),
                announcementCommentDto.getTeacherCode(),announcementCommentDto.getStudentCode(),announcementCommentDto.getAttachFile()
                ,announcementCommentDto.getAvatar(), announcementCommentDto.getName());
        return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
    }
}
