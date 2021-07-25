package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Teacher;
import com.codegym.back_end_sprint_2.repositories.ITeacherRepository;
import com.codegym.back_end_sprint_2.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher findByEmail(String email) {
        return teacherRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Teacher findByStudentCode(String code) {
        return teacherRepository.findById(code).orElse(null);
    }
}
