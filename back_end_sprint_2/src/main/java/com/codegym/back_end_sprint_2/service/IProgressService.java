package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.ProgressDto;
import com.codegym.back_end_sprint_2.model.dto.ProgressStudentDto;

import java.util.List;

public interface IProgressService {
    List<ProgressDto> findAll();
    List<ProgressStudentDto> findAllStudent();
}
