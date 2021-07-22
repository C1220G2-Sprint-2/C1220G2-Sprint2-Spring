package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.dto.StudentDto;

public interface StudentDtoService {
    StudentDto findQueryById(String code);
}
