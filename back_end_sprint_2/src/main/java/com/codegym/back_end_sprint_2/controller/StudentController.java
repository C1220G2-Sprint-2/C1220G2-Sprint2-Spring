package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import com.codegym.back_end_sprint_2.model.entities.*;
import com.codegym.back_end_sprint_2.model.entities.Class;
import com.codegym.back_end_sprint_2.repository.*;
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
    @Autowired
    ClassRepository classRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    TeacherRepository teacherRepository;

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
        mailService.sendEmailAccountStudent(student.getCode(), studentDto.getEmail());

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
        userRepository.deleteByCodeStudent(code);
    }

    @DeleteMapping("/block/{code}/{name}/{team}")
    public void block(@PathVariable String code,
                      @PathVariable String name,
                      @PathVariable String team
    ) throws MessagingException {
        studentService.block(code);
        userRepository.deleteByCodeStudent(code);
        Teacher teacher = teacherRepository.findTeacherByTeam(team);
        List<StudentDto> studentDtoList = studentDtoService.findStudentsByTeam(team);
        mailService.sendEmailBlockStudent(code, name, teacher.getEmail(), teacher.getName(),team);

        for (StudentDto studentDto : studentDtoList) {
            mailService.sendEmailBlockStudent(code, name, studentDto.getEmail(), studentDto.getName(),team);

        }

    }

    @GetMapping("/class")
    public List<Class> findAllClass(){
        return classRepository.findAll();
    }

    @GetMapping("/faculty")
    public List<Faculty> findAllFaculty(){
        return facultyRepository.findAll();
    }


}
