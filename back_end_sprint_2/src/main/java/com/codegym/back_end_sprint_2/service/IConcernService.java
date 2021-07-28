package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.ConcernDto;

import java.util.List;

public interface IConcernService {

    List<ConcernDto> findAll();

    void save(String attachFile, String content, String title, String studentCode, String avatar, String name,Byte enable);
}
