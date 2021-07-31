package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.PhaseDto;
import com.codegym.back_end_sprint_2.model.dto.ProgressDto;
import com.codegym.back_end_sprint_2.model.dto.ProgressStudentDto;
import com.codegym.back_end_sprint_2.model.dto.ProjectDto;
import com.codegym.back_end_sprint_2.model.entities.Progress;
import com.codegym.back_end_sprint_2.model.entities.Teacher;

import java.util.List;

public interface IProgressService {
    List<ProgressDto> findAll();

    List<ProgressDto> searchByName(String name);

    List<ProgressStudentDto> findAllStudent();

    List<ProgressStudentDto> findStudentByIdGroup(Long projectId);

    ProjectDto findProjectDtoByID(Long id);

    Teacher findTeacherByCode(String code);

    List<PhaseDto> findProgressByProject(int projectId);

    Progress findByStatus(int projectId);

    Progress findById(Long id);
}
