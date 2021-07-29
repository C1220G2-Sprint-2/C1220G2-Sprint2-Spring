package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.ConcernCommentDto;

import java.util.List;

public interface ICommentConcernService {

    List<ConcernCommentDto> findAll();

    void saveCommentConcern(ConcernCommentDto concernCommentDto);

    String getStudentEmail(Long concernId);
}
