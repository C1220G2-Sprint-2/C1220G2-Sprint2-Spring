package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface ITeacherService {
    List<Teacher> findAll();

    Teacher save(Teacher teacher);
}
