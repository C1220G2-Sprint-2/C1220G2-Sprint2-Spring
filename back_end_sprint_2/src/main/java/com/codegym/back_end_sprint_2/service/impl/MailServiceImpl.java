package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.TeamDto;
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
    public String emailTeam(Student student, TeamDto teamDto) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;

        String urlDisagree= "http://localhost:8080/api/team/disagree?codeStudent=".concat(student.getCode());
        String urlAgree= "http://localhost:8080/api/team/agree?codeStudent=".concat(student.getCode()).concat("&teamId=").concat(String.valueOf(teamDto.getId()));
        String htmlMsg = "<div style=\"text-align: center\">\n" +
        "    <img src=\"https://milemir.com/wp-content/uploads/2020/11/team.jpg\" alt=\"lỗi hình ảnh\">\n" +
        "    <h3> Thư mời vào nhóm</h3>\n" +
        "    Bạn được mời vào nhóm làm dự án tốt nghiệp\n" +
        "  <span>\n" +
        "    <br>\n" +
        "      <table style=\"display: inline-block;text-align: left\">\n" +
        "          <tr>\n" +
        "              <td >Tên Nhóm</td>\n" +
        "              <td>: "+teamDto.getName() +"</td>\n" +
        "          </tr>\n" +
        "          <tr>\n" +
        "              <td>Trưởng nhóm</td>\n" +
        "              <td>: "+teamDto.getTeamLeader()+"</td>\n" +
        "          </tr>\n" +
        "      </table>\n" +
        "      <br>\n" +
        "  </span>\n" +
        "    <a href='"+ urlDisagree +"' style='display:inline-block;text-decoration:none;background-color: black;color:#ffffff;padding:13px;border:0px solid #76b900;font-family: Roboto, sans-serif' >Từ chối</a>\n" +
        "    <a  href='"+ urlAgree+"'  style='display:inline-block;text-decoration:none;background-color: blue;color:#ffffff;padding:13px;border:0px solid #76b900;font-family: Roboto, sans-serif'>Đồng ý</a>\n" +
        "    <div style='height: 30px'> </div>\n" +
        "</div>" ;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");

        helper.setTo(student.getEmail());

        helper.setSubject("[Thư mời] Vào nhóm đồ án tốt nghiệp");
        this.emailSender.send(message);
        return "Email Sent http!";
    }

    @Override
    public String emailCcTeamLeader(Student student,String check) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;

        String url= "http://localhost:4200/nhom/dang-ky";

        String htmlMsg = "<div style=\"text-align: center\">\n" +
                "    <img src=\"https://milemir.com/wp-content/uploads/2020/11/team.jpg\" alt=\"lỗi hình ảnh\">\n" +
                "    <h3> Thành viên: "+student.getName() +" đã "+ check +" lời đề nghị của bạn</h3>\n" +
                "    <a href='"+ url +"' style='display:inline-block;text-decoration:none;background-color: black;color:#ffffff;padding:13px;border:0px solid #76b900;font-family: Roboto, sans-serif' >Về trang nhóm</a>\n" +
                "    <div style='height: 30px'> </div>\n" +
                "</div>" ;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(htmlMsg, "text/html; charset=UTF-8");

        helper.setTo(student.getEmail());

        helper.setSubject("[Xác nhận] Của thành viên trong nhóm");
        this.emailSender.send(message);
        return "Email Sent http!";
    }

}

