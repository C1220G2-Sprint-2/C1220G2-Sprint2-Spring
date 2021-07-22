package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.repositories.ProjectReponsitory;
import com.codegym.back_end_sprint_2.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectReponsitory projectReponsitory;

    @Override
    public List<Project> findAll() {
        return projectReponsitory.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectReponsitory.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectReponsitory.save(project);
    }

    @Override
    public void deleteById(Long idDelete) {
        projectReponsitory.deleteById(idDelete);
    }

    @Override
    public Project findByTeam(Long id) {
        return projectReponsitory.findByTeam_Id(id);
    }


}
