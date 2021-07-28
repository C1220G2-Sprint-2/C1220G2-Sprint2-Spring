//package com.codegym.back_end_sprint_2.service.impl;
//
//import com.codegym.back_end_sprint_2.model.dto.StudentCreateDto;
//import com.codegym.back_end_sprint_2.model.dto.TeacherCreateDto;
//import com.codegym.back_end_sprint_2.repositories.IStudentTeacherRepository;
//import com.codegym.back_end_sprint_2.service.IStudentTeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StudentTeacherServiceImpl implements IStudentTeacherService {
//    @Autowired
//    private IStudentTeacherRepository studentTeacherRepository;
//
//    @Override
//    public void createStudent(StudentCreateDto studentCreateDto) {
//        studentTeacherRepository.createStudent(
//                studentCreateDto.getAddress(),studentCreateDto.getDateOfBirth(),studentCreateDto.getEmail(),true,studentCreateDto.getGender(),
//                studentCreateDto.getName(),studentCreateDto.getPhone(),true
//        );
//    }
//
//    @Override
//    public void createTeacher(TeacherCreateDto teacherCreateDto) {
//
//    }
//
//}
