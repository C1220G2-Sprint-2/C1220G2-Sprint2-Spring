package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import com.codegym.back_end_sprint_2.repository.StudentDtoRepository;
import com.codegym.back_end_sprint_2.service.StudentDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDtoServiceImpl implements StudentDtoService {

    @Autowired
    StudentDtoRepository studentDtoRepository;

    @Override
    public StudentDto findQueryById(String code) {
        return studentDtoRepository.findQueryById(code);
    }
}
