package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProjectService {
    void deleteById(Long id);

    Page<Project> findAll(Pageable pageable);

    Project findById(Long id);

    void delete(Boolean enable, Long id);
}
