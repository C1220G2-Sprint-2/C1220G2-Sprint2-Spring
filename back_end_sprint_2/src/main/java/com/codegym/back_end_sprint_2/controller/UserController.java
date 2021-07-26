package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.JwtResponse;
import com.codegym.back_end_sprint_2.model.dto.MessageResponse;
import com.codegym.back_end_sprint_2.model.dto.PasswordDto;
import com.codegym.back_end_sprint_2.model.entities.User;
import com.codegym.back_end_sprint_2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/api")
@PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER')")
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    private PasswordEncoder encoder;

//    change password
    @PatchMapping("/user-change-password/{userCode}")
    @ResponseBody
    public ResponseEntity<MessageResponse> changeUserPassword(@PathVariable("userCode") String userCode, @RequestBody PasswordDto passwordDto) {
        String oldPassword = passwordDto.getOldPassword();
        String newPassword = passwordDto.getNewPassword();
        User user = userService.findByUsername(userCode);
        if (!userPasswordCheck(oldPassword, user)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Mật khẩu cũ không đúng. Vui lòng nhập lại."));
        } else {
            userService.updateUserPassword(encoder.encode(newPassword), userCode);
            return ResponseEntity.ok(new MessageResponse("Đổi mật khẩu thành công"));
        }
    }
    public boolean userPasswordCheck(String password, User user) {
        PasswordEncoder passEncoder = new BCryptPasswordEncoder();
        String encodedPassword = user.getPassword();
        return passEncoder.matches(password, encodedPassword);
    }
    @GetMapping("/hello")
    public  String hello (){
        return "hello";
    }


}
