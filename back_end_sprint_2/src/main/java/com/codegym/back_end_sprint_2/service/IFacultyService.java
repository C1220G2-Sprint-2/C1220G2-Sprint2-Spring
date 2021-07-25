package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Faculty;

import java.util.List;

public interface IFacultyService {
    List<Faculty> findAll();

    Faculty findById(Long id);
}
