package com.codegym.back_end_sprint_2.service.impl;
import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.repositories.IProjectRepository;

import com.codegym.back_end_sprint_2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProjectServiceImplP implements ProjectService {
    @Autowired
    private IProjectRepository projectRepository;
    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
    @Override
    public void delete(Boolean enable, Long id) {
        projectRepository.delete(enable, id);
    }
    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
    @Override
    public Page<Project> findAllApprove(Pageable pageable) {
        return projectRepository.findAllApprove(pageable);
    }
    @Override
    public void approveProject(Boolean status, Long id) {
        projectRepository.approveProject(status, id);
    }
    @Override
    public void notApproveProject(Boolean enable, Long id) {
        projectRepository.notApproveProject(enable, id);
    }
    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
    @Override
    public Project findByTeam(Long id) {
        return projectRepository.findByTeam_Id(id);
    }
    @Override
    public List<Project> searchProject(String keyword) {
        return projectRepository.searchProject(keyword);
    }
    @Override
    public String[] getStudentMail(Long id) {
        return projectRepository.getStudentMail(id);
    }
}