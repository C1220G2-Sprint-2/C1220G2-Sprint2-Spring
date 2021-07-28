package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.MessageResponse;
import com.codegym.back_end_sprint_2.model.dto.ProjectTeacherDto;
import com.codegym.back_end_sprint_2.model.dto.TeacherDto;
import com.codegym.back_end_sprint_2.model.entities.*;
import com.codegym.back_end_sprint_2.repository.IRoleRepository;
import com.codegym.back_end_sprint_2.repository.IUserRepository;
import com.codegym.back_end_sprint_2.service.*;
import com.codegym.back_end_sprint_2.ulti.MailService;
import com.codegym.back_end_sprint_2.until.EncryptPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.*;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private static final String ROLE_TEACHER = "ROLE_TEACHER";

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IFacultyService facultyService;

    @Autowired
    private IEducationService educationService;

    @Autowired
    private MailService mailService;

    @GetMapping("/list-faculty")
    public ResponseEntity<List<Faculty>> getAllListFaculty(){
        List<Faculty> facultyList = facultyService.findAll();
        if (facultyList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facultyList,HttpStatus.OK);
    }

    @GetMapping("/list-education")
    public ResponseEntity<List<Education>> getAllListEducation(){
        List<Education> educationList = educationService.findAll();
        if (educationList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(educationList,HttpStatus.OK);
    }

    @GetMapping("/list-teacher")
    public ResponseEntity<List<TeacherDto>> getAllListTeacher() {
        List<Teacher> teacherList = teacherService.findAll();
        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<TeacherDto> teacherDtoList = new ArrayList<>();

        for (Teacher teacher : teacherList) {
            TeacherDto teacherDto = new TeacherDto();
            transformFromTeacherToDto(teacher,teacherDto);
            teacherDtoList.add(teacherDto);
        }
        return new ResponseEntity<>(teacherDtoList,HttpStatus.OK);
    }

    @PostMapping("/create-teacher")
    public ResponseEntity<?> createTeacher(@RequestBody TeacherDto teacherDto) throws MessagingException {
        List<Teacher> teacherList = teacherService.findAll();
        for (Teacher teacher: teacherList){
            if (!teacher.getCode().equals(teacherDto.getCode()) && (teacher.getEmail().equals(teacherDto.getEmail()) || teacher.getPhone().equals(teacherDto.getPhone()))) {
                return ResponseEntity.badRequest().body(new MessageResponse("Email hoặc số điện thoại đã tồn tại. Vui lòng sử dụng email và số điện thoại khác."));
            }
        }
        Teacher teacher = new Teacher();
        transformFromDtoToTeacher(teacher,teacherDto);
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
        mailService.sendEmailAccountTeacher(user.getUsername(),teacher.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detail-teacher/{code}")
    public ResponseEntity<TeacherDto> detailTeacher(@PathVariable String code){
        Optional<Teacher> teacherOptional = teacherService.findTeacherByCode(code);
        if (!teacherOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            Teacher teacher = teacherOptional.get();
            TeacherDto teacherDto = new TeacherDto();
            transformFromTeacherToDto(teacher,teacherDto);
            return new ResponseEntity<>(teacherDto, HttpStatus.OK);
        }
    }

    @PutMapping("/edit-teacher")
    public ResponseEntity<?> editTeacher(@RequestBody TeacherDto teacherDto){
        List<Teacher> teacherList = teacherService.findAll();
        for (Teacher teacher: teacherList){
            if (!teacher.getCode().equals(teacherDto.getCode()) && (teacher.getEmail().equals(teacherDto.getEmail()) || teacher.getPhone().equals(teacherDto.getPhone()))) {
                return ResponseEntity.badRequest().body(new MessageResponse("Email hoặc số điện thoại đã tồn tại. Vui lòng sử dụng email và số điện thoại khác."));
            }
        }
        Teacher teacher = new Teacher();
        transformFromDtoToTeacher(teacher,teacherDto);
        teacherService.save(teacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<TeacherDto>> search(@RequestParam String keyWord){
        List<Teacher> teacherList = teacherService.searchTeacher(keyWord);
        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<TeacherDto> teacherDtoList = new ArrayList<>();

        for (Teacher teacher : teacherList) {
            TeacherDto teacherDto = new TeacherDto();
            transformFromTeacherToDto(teacher,teacherDto);
            teacherDtoList.add(teacherDto);
        }
        return new ResponseEntity<>(teacherDtoList,HttpStatus.OK);
    }

    @GetMapping("/checkDelete")
    public ResponseEntity<?> checkDelete(@RequestParam String code){
        Optional<Teacher> deleteTeacherOptional = teacherService.findTeacherByCode(code);
        if (!deleteTeacherOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            Teacher teacher = deleteTeacherOptional.get();
            List<Project> projectList = teacher.getProjects();
            if (projectList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            List<ProjectTeacherDto> projectTeacherDtoList = new ArrayList<>();
            for (Project project: projectList) {
                ProjectTeacherDto projectTeacherDto = new ProjectTeacherDto();
                transformProjectToProjectTeacherDto(project,projectTeacherDto);
                projectTeacherDtoList.add(projectTeacherDto);
            }
            return new ResponseEntity<>(projectTeacherDtoList,HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> delete(@PathVariable("code") String code){
        try{
            Teacher teacher = teacherService.findTeacherByCode(code).get();
            teacher.setEnable(false);
            teacherService.save(teacher);
            userRepository.deleteByCodeTeacher(code);
            return new  ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void transformProjectToProjectTeacherDto(Project project, ProjectTeacherDto projectTeacherDto){
        projectTeacherDto.setId(project.getId());
        projectTeacherDto.setName(project.getName());
        projectTeacherDto.setTeacherCode(project.getTeacher().getCode());
    }

    private void transformFromTeacherToDto(Teacher teacher, TeacherDto teacherDto) {
        teacherDto.setCode(teacher.getCode());
        teacherDto.setName(teacher.getName());
        teacherDto.setDateOfBirth(teacher.getDateOfBirth());
        teacherDto.setGender(teacher.getGender());
        teacherDto.setPhone(teacher.getPhone());
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setAddress(teacher.getAddress());
        teacherDto.setTwitter(teacher.getTwitter());
        teacherDto.setImage(teacher.getImage());
        teacherDto.setFacebook(teacher.getFacebook());
        teacherDto.setFacultyId(teacher.getFaculty().getId());
        teacherDto.setEducationId(teacher.getEducation().getId());
    }

    private void transformFromDtoToTeacher(Teacher teacher, TeacherDto teacherDto) {
        teacher.setCode(teacherDto.getCode());
        teacher.setName(teacherDto.getName());
        teacher.setDateOfBirth(teacherDto.getDateOfBirth());
        teacher.setGender(teacherDto.getGender());
        teacher.setPhone(teacherDto.getPhone());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setAddress(teacherDto.getAddress());
        teacher.setTwitter(teacherDto.getTwitter());
        teacher.setImage(teacherDto.getImage());
        teacher.setFacebook(teacherDto.getFacebook());
        teacher.setFaculty(facultyService.findById(teacherDto.getFacultyId()));
        teacher.setEducation(educationService.findById(teacherDto.getEducationId()));
    }

}
