package com.codegym.back_end_sprint_2.service;


import com.codegym.back_end_sprint_2.model.entities.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAll();


    public Teacher findByCode(String code);

    Teacher save(Teacher student);

    void deleteByCode(String code);
}
