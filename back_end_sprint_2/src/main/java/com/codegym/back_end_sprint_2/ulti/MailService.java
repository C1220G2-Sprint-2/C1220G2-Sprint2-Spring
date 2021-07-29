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

    public void sendEmailAccountStudent(String account, String email) throws MessagingException {
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
        helper.setTo(email);
//        -------------------------------------
//        Cái này là cc nha, cũng có thể cc mảng String
//        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("Tài khoản sinh viên.");
        this.emailSender.send(message);

//        Cái này để trả lại cho trang 8080 nha, không dùng cũng đc
//        return "Email Sent http!";
    }

    public void sendEmailAccountTeacher(String account, String email) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
        String htmlMsg = "" +
                "<div style='background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(43,51,163,0.7539390756302521) 25%, rgba(0,212,255,1) 100%);height: 50px'></div>" +
                "<h3 style='; font-family: Roboto, sans-serif;'> Chào bạn. Đây là tài khoản đăng nhập của bạn trên hệ" +
                " thống quản lý đề tài của sinh viên</h3>\n" +
                "<h4>Tên tài khoản: </h4> \n" +
                "<p style='color: red'>" + account + "</p>" + "</br>" +
                "<h4>Mật khẩu: </h4> \n" +
                "<p style='color: red'>123456</p>" + "</br>" +
                "<div style='height: 30px; background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(43,51,163,0.7539390756302521) 25%, rgba(0,212,255,1) 100%)'> </div>";
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");
        helper.setTo(email);
        helper.setSubject("Thư gửi từ hệ thống quản lý đề tài sinh viên");
        this.emailSender.send(message);
    }


    public void sendEmailBlockStudent(String account, String name, String email, String nameOfMail, String team) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
//---------------------------------------------------
//        Phần này là nội dung Email nha anh em
        String htmlMsg =
                "<p>Xin chào "+ nameOfMail +":</p>" +
                "<p>Sinh viên "+ name +" thuộc nhóm "+"<span style='color = red'>"+team+"</span>"+" đã bị khóa.</p>" +
                "<p>Tài khoản "+ account +" đã bị khóa.</p>";


        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");
//        -------------------------------------------
//        Phần này là nơi mình muốn gửi đến nha, có thể dùng mảng String nếu muốn gửi nhiều người.
        helper.setTo(email);
//        -------------------------------------
//        Cái này là cc nha, cũng có thể cc mảng String
//        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("Khóa tài khoản sinh viên");
        this.emailSender.send(message);

//        Cái này để trả lại cho trang 8080 nha, không dùng cũng đc
//        return "Email Sent http!";
    }


    public void sendEmailToResetPassword(String password, String email) throws  MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        String htmlMsg = "<p>Xin chào, đầy là mật khẩu mới của bạn. Vui lòng đổi mật khẩu để đảm bảo an toàn cho tài khoản:</p>" +
                "<p>mật khẩu: "+password+"</p>";
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");
        helper.setTo(email);
        helper.setSubject("Reset mật khẩu");
        this.emailSender.send(message);
    }

}
