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
    public Teacher findByCode(String code) {
        return teacherRepository.findByCode(code);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }


    public Teacher findByName(String name) {
        return teacherRepository.findByName(name);
    }


    @Override
    public Optional<Teacher> findTeacherByCode(String code) {
        return teacherRepository.findTeacherByCode(code);
    }


    @Override
    public List<Teacher> searchTeacher(String keyWord) {
        return teacherRepository.searchTeacher(keyWord);
    }

//    CongNT code
    @Override
    public Teacher findByEmail(String email) {
        return teacherRepository.findByEmail(email).orElse(null);
    }

    @Override
    public boolean isEmailExist(String email) {
        return teacherRepository.existsByEmail(email);
    }

    @Override
    public boolean isPhoneExist(String phone) {
        return teacherRepository.existsByPhone(phone);
    }


}
