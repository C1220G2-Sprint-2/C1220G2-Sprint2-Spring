package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Teacher;

import java.util.List;


public interface ITeacherService {
    List<Teacher> findAll();

    Teacher save(Teacher teacher);

    Teacher findByEmail(String email);
    Teacher findByStudentCode(String code);

}
