package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Concern;
import com.codegym.back_end_sprint_2.repositories.IConcernRepository;
import com.codegym.back_end_sprint_2.service.IConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcernServiceImpl implements IConcernService {

    @Autowired
    private IConcernRepository concernRepository;

    @Override
    public List<Concern> findAll() {
        return concernRepository.findAll();
    }

    @Override
    public void save(String attachFile, String content, String title, Long notificationId, String studentCode, Byte enable) {
        concernRepository.saveConcern(attachFile,content,title,notificationId,studentCode,enable);
    }
}
