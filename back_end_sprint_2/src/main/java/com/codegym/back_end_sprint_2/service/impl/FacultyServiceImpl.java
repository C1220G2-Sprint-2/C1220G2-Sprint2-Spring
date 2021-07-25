package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Faculty;
import com.codegym.back_end_sprint_2.repositories.IFacultyRepository;
import com.codegym.back_end_sprint_2.service.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements IFacultyService {
    @Autowired
    private IFacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
}
