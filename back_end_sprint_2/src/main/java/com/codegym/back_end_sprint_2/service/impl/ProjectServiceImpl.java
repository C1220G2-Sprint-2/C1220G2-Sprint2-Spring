package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.repositories.ProjectRepository;
import com.codegym.back_end_sprint_2.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteById(Long idDelete) {
        projectRepository.deleteById(idDelete);
    }

    @Override
    public Project findByTeam(Long id) {
        return projectRepository.findByTeam_Id(id);
    }


}
