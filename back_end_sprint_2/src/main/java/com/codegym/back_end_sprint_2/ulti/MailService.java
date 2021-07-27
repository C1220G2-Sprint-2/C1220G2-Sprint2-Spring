package com.codegym.back_end_sprint_2.ulti;

import com.codegym.back_end_sprint_2.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    public JavaMailSender emailSender;

    public void sendEmailAccountStudent(String account) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
//---------------------------------------------------
//        Phần này là nội dung Email nha anh em
        String htmlMsg = "<p>Xin chào bạn, đầy là tài khoản của bạn:</p>" +
                "<p>tài khoản: " + account + "</p>"+
                "<p>mật khẩu: 123456</p>";

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");
//        -------------------------------------------
//        Phần này là nơi mình muốn gửi đến nha, có thể dùng mảng String nếu muốn gửi nhiều người.
        helper.setTo(MailConfig.FRIEND_EMAIL);
//        -------------------------------------
//        Cái này là cc nha, cũng có thể cc mảng String
        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("Đây là tiêu đề Mail nha anh em");
        this.emailSender.send(message);

//        Cái này để trả lại cho trang 8080 nha, không dùng cũng đc
//        return "Email Sent http!";
    }

}
