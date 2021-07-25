package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import com.codegym.back_end_sprint_2.model.entities.Role;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.User;
import com.codegym.back_end_sprint_2.repository.IRoleRepository;
import com.codegym.back_end_sprint_2.repository.IUserRepository;
import com.codegym.back_end_sprint_2.service.StudentDtoService;
import com.codegym.back_end_sprint_2.service.StudentService;
import com.codegym.back_end_sprint_2.ulti.MailService;
import com.codegym.back_end_sprint_2.until.EncryptPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/student")
public class StudentController {

    private static final String ROLE_STUDENT = "ROLE_STUDENT";

    @Autowired
    StudentService studentService;
    @Autowired
    StudentDtoService studentDtoService;
    @Autowired
    MailService mailService;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRoleRepository roleRepository;

    @GetMapping("/search")
    public List<StudentDto> findAll(@RequestParam(name = "keyword", required = false) String keyword){
    return studentService.listSearch(keyword);
    }

    @PostMapping()
    public void create(@RequestBody StudentDto studentDto) throws MessagingException {

        Student student = studentService.save(studentDto);
        User user = new User();
        user.setUsername(student.getCode());
        user.setPassword(EncryptPasswordUtils.EncodePassword("123456"));
        user.setStatus(true);
        user.setTeacher(null);
        user.setStudent(student);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName(ROLE_STUDENT));
        user.setRoles(roles);
        userRepository.save(user);
        mailService.sendEmailAccountStudent(student.getCode());

    }
    @GetMapping("/{code}")
    public StudentDto findById(@PathVariable String code){
        return studentDtoService.findQueryById(code);
    }
    @PutMapping("/{code}")
    public void edit(@PathVariable String code, @RequestBody StudentDto studentDto) {
        studentService.save(studentDto);

    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code){
        studentService.delete(code);
    }

    @RequestMapping("/test")
    public void test() throws MessagingException {
        mailService.sendEmailAccountStudent("tuanpro");
    }

}
