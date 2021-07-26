package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.config.jwt.JwtUtils;
import com.codegym.back_end_sprint_2.model.dto.JwtResponse;
import com.codegym.back_end_sprint_2.model.dto.LoginRequest;
import com.codegym.back_end_sprint_2.model.dto.MessageResponse;
import com.codegym.back_end_sprint_2.model.dto.UserDetailsImpl;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class LoginController {
    private static final String EMAIL = "tiennvt@codegym.com";
    private static final String IMAGE_ADMIN = "https://5.imimg.com/data5/DB/JO/GLADMIN-70100492/admin-login-portal-500x500.png";
    private static final String ADDRESS = "Đà Nẵng";
    private static final String PHONE = "0909999999";
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private StudentService studentService;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        if (userDetails.isEnabled()) {
            String email = EMAIL;
            String image = IMAGE_ADMIN;
            String address = ADDRESS;
            String phone = PHONE;
            if (userDetails.getUsername().charAt(0) == 'S') {
                Student student = studentService.findByStudentCode(userDetails.getUsername());
                email = student.getEmail();
                image = student.getImage();
                address = student.getAddress();
                phone = student.getPhone();
            }
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(), email,
                    roles, image, address, phone));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi đăng nhập."));
        }
    }

}
