package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.ProgressDto;
import com.codegym.back_end_sprint_2.model.dto.ProgressStudentDto;
import com.codegym.back_end_sprint_2.model.entities.Project;

import java.util.List;

public interface IProgressService {
    List<ProgressDto> findAll();
    List<Project> searchByName();
    List<ProgressStudentDto> findAllStudent();
}
