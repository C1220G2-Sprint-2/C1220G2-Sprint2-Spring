package com.codegym.back_end_sprint_2.controller;


import com.codegym.back_end_sprint_2.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class SimpleEmailExampleController {
    @Autowired
    public JavaMailSender emailSender;
//    @Autowired
//    private IUserService userService;

    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(MailConfig.FRIEND_EMAIL);
        message.setSubject("thu nghiem gui email,");
        message.setText("Hello, thang de");
        // Send Message!
        this.emailSender.send(message);
        return "Email Sent!";
    }

    @ResponseBody
    @RequestMapping("/sendHtmlEmail")
    public String sendHtmlEmail() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
//---------------------------------------------------
//        Phần này là nội dung Email nha anh em
        String htmlMsg = "<h1></h1>" ;
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");
//        -------------------------------------------
//        Phần này là nơi mình muốn gửi đến nha, có thể dùng mảng String nếu muốn gửi nhiều người.
//        -------------------------------------
//        Cái này là cc nha, cũng có thể cc mảng String

        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("Đây là tiêu đề Mail nha anh em");
        this.emailSender.send(message);

//        Cái này để trả lại cho trang 8080 nha, không dùng cũng đc
        return "Email Sent http!";
    }


}