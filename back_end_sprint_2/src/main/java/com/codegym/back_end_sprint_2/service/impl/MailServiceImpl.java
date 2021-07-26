package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.*;
import com.codegym.back_end_sprint_2.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    public JavaMailSender emailSender;


    @Override
    public String emailTeam(Student student, Team teamDto) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;

        String urlDisagree = "http://localhost:8080/api/team/disagree?codeStudent=".concat(student.getCode());
        String urlAgree = "http://localhost:8080/api/team/agree?codeStudent=".concat(student.getCode()).concat("&teamId=").concat(String.valueOf(teamDto.getId()));
        String htmlMsg = "<div style=\"text-align: center\">\n" +
                "    <img src=\"https://milemir.com/wp-content/uploads/2020/11/team.jpg\" alt=\"lỗi hình ảnh\">\n" +
                "    <h3> Thư mời vào nhóm</h3>\n" +
                "    Bạn được mời vào nhóm làm dự án tốt nghiệp\n" +
                "  <span>\n" +
                "    <br>\n" +
                "      <table style=\"display: inline-block;text-align: left\">\n" +
                "          <tr>\n" +
                "              <td >Tên Nhóm</td>\n" +
                "              <td>: " + teamDto.getName() + "</td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "              <td>Trưởng nhóm</td>\n" +
                "              <td>: " + teamDto.getTeamLeader() + "</td>\n" +
                "          </tr>\n" +
                "      </table>\n" +
                "      <br>\n" +
                "  </span>\n" +
                "    <a href='" + urlDisagree + "' style='display:inline-block;text-decoration:none;background-color: black;color:#ffffff;padding:13px;border:0px solid #76b900;font-family: Roboto, sans-serif' >Từ chối</a>\n" +
                "    <a  href='" + urlAgree + "'  style='display:inline-block;text-decoration:none;background-color: blue;color:#ffffff;padding:13px;border:0px solid #76b900;font-family: Roboto, sans-serif'>Đồng ý</a>\n" +
                "    <div style='height: 30px'> </div>\n" +
                "</div>";

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");

        helper.setTo(student.getEmail());

        helper.setSubject("[Thư mời] Vào nhóm đồ án tốt nghiệp");
        this.emailSender.send(message);
        return "Email Sent http!";
    }


    @Override
    public String emailCcTeamLeader(Student student, String check) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;

        String url = "http://localhost:4200/nhom/quan-ly-nhom";

        String htmlMsg = "<div style=\"text-align: center\">\n" +
                "    <img src=\"https://milemir.com/wp-content/uploads/2020/11/team.jpg\" alt=\"lỗi hình ảnh\">\n" +
                "    <h3> Thành viên: " + student.getName() + " đã " + check + " lời đề nghị của bạn</h3>\n" +
                "    <a href='" + url + "' style='display:inline-block;text-decoration:none;background-color: black;color:#ffffff;padding:13px;border:0px solid #76b900;font-family: Roboto, sans-serif' >Về trang nhóm</a>\n" +
                "    <div style='height: 30px'> </div>\n" +
                "</div>";

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");

        helper.setTo(student.getEmail());

        helper.setSubject("[Xác nhận] Của thành viên trong nhóm");
        this.emailSender.send(message);
        return "Email Sent http!";
    }


    @Override
    public String emailToTeacher( Project project) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;

        String url = "http://localhost:4200/";
        String htmlMsg = "<div style=\"text-align: center\">\n" +
                "    <img src=\"data:image/jpeg;base64,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\" alt=\"lỗi hình ảnh\">\n" +
                "    <h3> Đề tài đăng ký</h3>\n" +
                "    Bạn được chọn làm giáo viên hướng dẫn cho đề tài\n" +
                "  <span>\n" +
                "    <br>\n" +
                "      <table style=\"display: inline-block;text-align: left\">\n" +
                "          <tr>\n" +
                "              <td >Tên đề tài</td>\n" +
                "              <td>: " + project.getName() + "</td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "              <td>Trưởng nhóm</td>\n" +
                "              <td>: " + project.getTeam().getTeamLeader() + "</td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "              <td >Nội dung</td>\n" +
                "              <td>: " + project.getContent() + "</td>\n" +
                "          </tr>\n" +
                "      </table>\n" +
                "      <br>\n" +
                "    <a href='" + url + "' style='display:inline-block;text-decoration:none;background-color: black;color:#ffffff;padding:13px;border:0px solid #76b900;font-family: Roboto, sans-serif' >Về trang chủ</a>\n" +
                "  </span>\n" +
                "    <div style='height: 30px'> </div>\n" +
                "</div>";

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");

        helper.setTo(project.getTeacher().getEmail());

        helper.setSubject("[Thông báo] Đề tài mới");
        this.emailSender.send(message);
        return "Email Sent http!";
    }
}

