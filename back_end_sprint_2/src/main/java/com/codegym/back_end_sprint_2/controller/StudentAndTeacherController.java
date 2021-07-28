package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import com.codegym.back_end_sprint_2.model.dto.StudentCreateDto;
import com.codegym.back_end_sprint_2.model.dto.TeacherCreateDto;
import com.codegym.back_end_sprint_2.model.dto.TeacherDto;
import com.codegym.back_end_sprint_2.model.entities.*;
import com.codegym.back_end_sprint_2.repositories.IEducationRepository;
import com.codegym.back_end_sprint_2.repository.*;
import com.codegym.back_end_sprint_2.service.*;
import com.codegym.back_end_sprint_2.ulti.MailService;
import com.codegym.back_end_sprint_2.until.EncryptPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/teacher-student")
public class StudentAndTeacherController {
    private static final String ROLE_STUDENT = "ROLE_STUDENT";
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private MailService mailService;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;

    private static final String ROLE_TEACHER = "ROLE_TEACHER";
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IFacultyService facultyService;
    @Autowired
    private IEducationService educationService;

    @PostMapping("/create-student")
    public void createStudent(@RequestBody List<StudentCreateDto> studentDto) throws MessagingException {
        for (StudentCreateDto students : studentDto) {
            Student student = new Student();
            student.setName(students.getName());
            student.setAddress(students.getAddress());
            student.setDateOfBirth(students.getDateOfBirth());
            student.setEmail(students.getEmail());
            student.setEnable(true);
            student.setFacebook("");
            student.setGender(students.getGender());
            student.setGroupStatus(0.5);
            student.setImage("");
            student.setPhone(students.getPhone());
            student.setStatus(true);
            System.out.println(students.getaClass());
            System.out.println(students.getFaculty());
            student.setaClass(classRepository.findByName(students.getaClass()));
            student.setFaculty(facultyRepository.findByName(students.getFaculty()));
            student.setTeam(teamRepository.findById(1L).orElse(null));
            studentService.save(student);
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
            mailService.sendEmailAccountStudent(user.getUsername(),student.getEmail());

        }
    }

    @PostMapping("/create-teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody List<TeacherCreateDto> teacherDto) {
        for (TeacherCreateDto teacherDto1 : teacherDto) {
            Teacher teacher = new Teacher();
            transformFromDtoToTeacher(teacher, teacherDto1);
            teacher = teacherService.save(teacher);
            User user = new User();
            user.setUsername(teacher.getCode());
            user.setPassword(EncryptPasswordUtils.EncodePassword("123456"));
            user.setStatus(true);
            user.setTeacher(null);
            user.setTeacher(teacher);
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName(ROLE_TEACHER));
            user.setRoles(roles);
            userRepository.save(user);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void transformFromDtoToTeacher(Teacher teacher, TeacherCreateDto teacherDto) {
        teacher.setCode(teacherDto.getCode());
        teacher.setName(teacherDto.getName());
        teacher.setDateOfBirth(teacherDto.getDateOfBirth());
        teacher.setGender(teacherDto.getGender());
        teacher.setEnable(true);
        teacher.setPhone(teacherDto.getPhone());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setAddress(teacherDto.getAddress());
        teacher.setFaculty(facultyService.findByName(teacherDto.getFacultyId()));
        teacher.setEducation(educationService.findByName(teacherDto.getEducationId()));
    }
}
