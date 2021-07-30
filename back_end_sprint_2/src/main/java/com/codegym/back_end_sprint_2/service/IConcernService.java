package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.ConcernDto;

import java.util.List;

public interface IConcernService {

    List<ConcernDto> findAll(Long noOfPage);

    void save(ConcernDto concernDto);

    int maxLengthListReview();

    String getTeacherCode(String studentCode);
}
