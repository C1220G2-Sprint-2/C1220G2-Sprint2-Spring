package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Education;

import java.util.List;
import java.util.Optional;

public interface IEducationService {
    List<Education> findAll();

    Education findById(Long id);
}
