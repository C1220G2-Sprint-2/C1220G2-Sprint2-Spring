package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Education;
import com.codegym.back_end_sprint_2.repositories.IEducationRepository;
import com.codegym.back_end_sprint_2.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService {
    @Autowired
    private IEducationRepository educationRepository;

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Education findById(Long id) {
        return educationRepository.findById(id).orElse(null);
    }

    @Override
    public Education findByName(String name) {
        return educationRepository.findByName(name);
    }
}
