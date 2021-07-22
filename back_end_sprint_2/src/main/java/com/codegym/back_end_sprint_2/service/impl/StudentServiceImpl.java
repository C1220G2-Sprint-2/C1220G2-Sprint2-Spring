package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.repositories.IStudentRepository;
import com.codegym.back_end_sprint_2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public String[] getMailStudent() {
        return studentRepository.getMailStudent();
    }
}
