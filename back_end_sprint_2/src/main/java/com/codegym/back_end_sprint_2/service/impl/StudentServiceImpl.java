package com.codegym.back_end_sprint_2.service.impl;



import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.repositories.IStudentRepository;
import com.codegym.back_end_sprint_2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.codegym.back_end_sprint_2.dto.StudentDto;
import com.codegym.back_end_sprint_2.repository.*;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements  StudentService {

    @Autowired
    IStudentRepository IStudentRepository;

    @Autowired
    StudentDtoRepository studentDtoRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    TeamRepository teamRepository;


    @Override
    public List<Student> findAllJpa() {
        return IStudentRepository.findAll(); }

    @Override
    public List<StudentDto> findAll() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> studentList = IStudentRepository.findAll();
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
    public Student findByCode(String code) {
        return IStudentRepository.findByCode(code);
    }

    @Override
    public Student save(Student student) {
        return IStudentRepository.save(student);
    }

    @Override
    public void deleteByCode(String code) {
    }


    public List<StudentDto> listSearch(String keyword) {
        return studentDtoRepository.listSearch(keyword);
    }

    @Override
    public void save(StudentDto studentDto) {
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

        IStudentRepository.save(student);
    }

    @Override
    public void delete(String code) {
//        studentRepository.deleteByCodeS(code);
    }


}
