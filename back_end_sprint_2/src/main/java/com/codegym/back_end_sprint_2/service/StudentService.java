package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import com.codegym.back_end_sprint_2.model.entities.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();
    List<StudentDto> listSearch(String keyword);
    Student save(StudentDto studentDto);
    void delete(String code);
    void block(String code);
}
