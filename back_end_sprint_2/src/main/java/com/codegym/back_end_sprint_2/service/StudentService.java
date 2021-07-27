package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import com.codegym.back_end_sprint_2.model.entities.Student;


import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDto> findAll();
    List<Student> findAllJpa();
    List<StudentDto> listSearch(String keyword);


     Student findByCode(String code);

    Student save(Student student);


    Student save(StudentDto studentDto);
    void delete(String code);
    Student findByStudentCode(String code);
    Student findByEmail(String email);

}
