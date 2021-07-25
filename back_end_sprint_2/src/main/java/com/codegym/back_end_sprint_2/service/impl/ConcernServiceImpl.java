package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Concern;
import com.codegym.back_end_sprint_2.repositories.IConcernRepository;
import com.codegym.back_end_sprint_2.service.IConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConcernServiceImpl implements IConcernService {

    @Autowired
    private IConcernRepository concernRepository;

    @Override
    public Page<Concern> findAll(Pageable pageable) {
        return concernRepository.findAll(pageable);
    }

    @Override
    public void save(String attachFile, String content, String title, Long notificationId, String studentCode, String teacherCode, Byte enable) {
        concernRepository.saveConcern(attachFile,content,title,notificationId,studentCode,teacherCode,enable);
    }
}
