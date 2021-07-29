package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.config.MailConfig;
import com.codegym.back_end_sprint_2.model.dto.ConcernDto;
import com.codegym.back_end_sprint_2.model.dto.MessageResponse;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Teacher;
import com.codegym.back_end_sprint_2.repositories.IStudentRepository;
import com.codegym.back_end_sprint_2.repositories.ITeacherRepository;
import com.codegym.back_end_sprint_2.service.IConcernService;
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
@RequestMapping(value = "/api/concern")
public class ConcernController {

    @Autowired
    private IConcernService concernService;
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private ITeacherRepository teacherRepository;
    @Autowired
    public JavaMailSender emailSender;

    private String email;
    private String title;
    private String content;
    private Long projectId;

    @GetMapping("/student-concern-list/{noOfRecord}")
    public ResponseEntity<List<ConcernDto>> getListConcernByNo(@PathVariable("noOfRecord") Long noOfRecord) {
        List<ConcernDto> concernList = concernService.findAll(noOfRecord);
        if (concernList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(concernList, HttpStatus.OK);
    }

    @PostMapping("/student-concern-save")
    public ResponseEntity<MessageResponse> saveConcern(@RequestBody ConcernDto concern) {
        this.projectId = concern.getProjectId();
        this.title = concern.getTitle();
        this.content = concern.getContent();
        try {
            concernService.save(concern);
            return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-size")
    public ResponseEntity<?> getMaxSizeConcernList() {
        try {
            return new ResponseEntity<>(concernService.maxLengthListReview(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @GetMapping("/send-email/{studentCode}")
    public String sendHtmlEmail(@PathVariable("studentCode") String studentCode) throws MessagingException {
        this.email = getTeacherEmail(studentCode);
        String name = studentRepository.findByCode(studentCode).getName();
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
        String htmlMsg = "<div style=\"text-align: center\">\n" +
                "    <img src=\"https://www.getjobsalert.in/wp-content/uploads/2020/07/bell.gif\" alt=\"lỗi hình ảnh\"><br><br>" +
                "<h3>Bạn có một thắc mắc đang chờ trả lời từ "+name+":</h3>" +
                "<h4>"+this.title+"</h4>" +
                "<h4>"+this.content+"</h4>" +
                "<a href=\"http://localhost:4200/quan-ly-tien-do/chi-tiet-tien-do/"+this.projectId+"\">Nhấn vào đây để xem</a>" +
                "    <div style='height: 30px'> </div>\n" +
                "</div>";
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");
        helper.setTo(this.email);
        helper.setSubject("Có một thắc mắc đang chờ trả lời");
        this.emailSender.send(message);
        return "Email Sent http!";
    }

    public String getTeacherEmail(String studentCode) {
        Teacher teacher = teacherRepository.findByCode(concernService.getTeacherCode(studentCode));
        return teacher.getEmail();
    }
}
