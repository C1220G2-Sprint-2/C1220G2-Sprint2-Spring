package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAll();

    public Student findByCode(String code);

    Student save(Student student);

    void deleteByCode(String code);
}
