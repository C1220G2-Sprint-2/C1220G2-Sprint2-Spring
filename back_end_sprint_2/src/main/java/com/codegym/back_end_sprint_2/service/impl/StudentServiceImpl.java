package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.repository.*;
import com.codegym.back_end_sprint_2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentDtoRepository studentDtoRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    TeamRepository teamRepository;

    @Override
    public List<StudentDto> findAll() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            studentDtoList.add(new StudentDto(
                    student.getCode(),
                    student.getName(),
                    student.getPhone(),
                    student.getaClass().getName(),
                    student.getEmail(),
                    student.getImage(),
                    student.getFaculty().getName(),
                    student.getFacebook(),
                    student.isStatus()));
        }
        return studentDtoList;
    }


    @Override
    public List<StudentDto> listSearch(String keyword) {
        return studentDtoRepository.listSearch(keyword);
    }

    @Override
    public Student save(StudentDto studentDto) {
        Student student = new Student();
        if (null != studentDto.getCode()){
            student.setCode(studentDto.getCode());
        }
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setEmail(studentDto.getEmail());
        student.setEnable(true);
        student.setFacebook(studentDto.getFacebook());
        student.setGender(studentDto.getGender());
        student.setGroupStatus(0.5);
        student.setImage(studentDto.getImage());
        student.setPhone(studentDto.getPhone());
        student.setStatus(true);
        student.setaClass(classRepository.findById(Long.valueOf(studentDto.getClassStudent())).orElse(null));
        student.setFaculty(facultyRepository.findById(Long.valueOf(studentDto.getFaculty())).orElse(null));
        student.setTeam(teamRepository.findById(1L).orElse(null));

       return studentRepository.save(student);

    }

    @Override
    public void delete(String code) {
        studentRepository.deleteByCodeS(code);
    }

    @Override
    public Student findByStudentCode(String code) {
        return studentRepository.findById(code).orElse(null);
    }

}
