package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Concern;

import java.util.List;

public interface IConcernService {

    List<Concern> findAll();

    void save(String attachFile, String content, String title, Long notificationId, String studentCode,Byte enable);
}
