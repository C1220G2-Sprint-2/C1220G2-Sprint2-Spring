package com.codegym.back_end_sprint_2.service;


import com.codegym.back_end_sprint_2.model.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    void deleteById(Long id);
    List<Project> findAll();
    Project findById(Long id);
    void delete(Boolean enable, Long id);
    Page<Project> findAllApprove(Pageable pageable);
    void approveProject(Boolean status, Long id);
    void notApproveProject(Boolean enable, Long id);
    Project save(Project project);
    Project findByTeam(Long id);
    List<Project> searchProject(String keyword);
    String[] getStudentMail(Long id);

}
