package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.ConcernCommentDto;

import java.util.List;

public interface ICommentConcernService {

    List<ConcernCommentDto> findAll();

    void saveCommentConcern(String content, Long concernId, String studentCode, String teacherCode,String attachFile, String avatar, String name);
}
