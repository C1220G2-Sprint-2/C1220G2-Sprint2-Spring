package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.TeacherDto;
import com.codegym.back_end_sprint_2.model.entities.Education;
import com.codegym.back_end_sprint_2.model.entities.Faculty;
import com.codegym.back_end_sprint_2.model.entities.Teacher;
import com.codegym.back_end_sprint_2.model.entities.User;
import com.codegym.back_end_sprint_2.service.IEducationService;
import com.codegym.back_end_sprint_2.service.IFacultyService;
import com.codegym.back_end_sprint_2.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private IFacultyService facultyService;

    @Autowired
    private IEducationService educationService;

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
    public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        transformFromDtoToTeacher(teacher,teacherDto);
        teacher = teacherService.save(teacher);
        User user = new User();
        user.setTeacher(teacher);
        user.setPassword("123456");
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
    public ResponseEntity<Teacher> editTeacher(@RequestBody TeacherDto teacherDto){
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
