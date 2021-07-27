package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.dto.StudentDto;

import java.util.List;

public interface StudentDtoService {
    StudentDto findQueryById(String code);
    List<StudentDto> findStudentsByTeam(String team);

}
