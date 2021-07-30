package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.*;
import com.codegym.back_end_sprint_2.service.ICommentAnnouncementService;
import com.codegym.back_end_sprint_2.service.ICommentConcernService;
import com.codegym.back_end_sprint_2.service.ICommentReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/api/comment")
public class CommentController {

    @Autowired
    private ICommentConcernService commentConcernService;
    @Autowired
    private ICommentAnnouncementService commentAnnouncementService;
    @Autowired
    private ICommentReviewService commentReviewService;
    @Autowired
    public JavaMailSender emailSender;

    private String email;
    private String name;
    private String content;
    private Long projectId;

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
        this.projectId = concernComment.getProjectId();
        this.name = concernComment.getName();
        this.content = concernComment.getContent();
        try {
            commentConcernService.saveCommentConcern(concernComment);
            return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
        try {
            commentAnnouncementService.saveCommentConcern(announcementComment);
            return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/review/comment-list")
    public ResponseEntity<List<ReviewCommentDto>> getListReviewComment() {
        List<ReviewCommentDto> reviewCommentDtoList = commentReviewService.findAll();
        if (reviewCommentDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviewCommentDtoList, HttpStatus.OK);
    }

    @PostMapping("/review/comment-save")
    public ResponseEntity<MessageResponse> saveReviewComment(@RequestBody ReviewCommentDto reviewComment) {
        try {
            commentReviewService.saveCommentReview(reviewComment);
            return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @GetMapping("/concern/send-email/{concernId}")
    public String sendHtmlEmail(@PathVariable("concernId") Long concernId) throws MessagingException {
        this.email = getStudentEmail(concernId);
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
        String htmlMsg = "<div style=\"text-align: center\">\n" +
                "    <img src=\"https://www.getjobsalert.in/wp-content/uploads/2020/07/bell.gif\" alt=\"lỗi hình ảnh\"><br><br>" +
                "<h3>Thắc mắc của bạn đã được trả lời từ " + this.name + ":</h3>" +
                "<h4>" + this.content + "</h4>" +
                "<a href=\"http://localhost:4200/quan-ly-tien-do/chi-tiet-tien-do/" + this.projectId + "\">Nhấn vào đây để xem</a>" +
                "    <div style='height: 30px'> </div>\n" +
                "</div>";
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");
        helper.setTo(this.email);
        helper.setSubject("Thắc mắc của bạn đã được trả lời.");
        this.emailSender.send(message);
        return "Email Sent http!";
    }

    public String getStudentEmail(Long concernId) {
        return commentConcernService.getStudentEmail(concernId);
    }
}
