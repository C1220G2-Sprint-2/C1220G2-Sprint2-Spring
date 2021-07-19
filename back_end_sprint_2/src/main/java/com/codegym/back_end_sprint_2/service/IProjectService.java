package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    List<Project> findAll();


    Optional<Project> findById(Long id);

    Project save(Project project);

    void deleteById(Long idDelete);
}
