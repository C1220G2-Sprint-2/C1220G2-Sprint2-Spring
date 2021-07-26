package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.ConcernDto;
import com.codegym.back_end_sprint_2.model.dto.ProgressDto;
import com.codegym.back_end_sprint_2.model.entities.Concern;
import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.repositories.IConcernRepository;
import com.codegym.back_end_sprint_2.service.IConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConcernServiceImpl implements IConcernService {

    @Autowired
    private IConcernRepository concernRepository;

    @Override
    public List<ConcernDto> findAll() {
        List<ConcernDto> concernDtoList = new ArrayList<>();
        List<Concern> concernList = concernRepository.findAll();
        for (Concern concern : concernList) {
            concernDtoList.add(new ConcernDto(concern.getId(),concern.getTitle(),concern.getContent(),concern.getStudent().getCode(),concern.getAttachFile()));
        }
        return concernDtoList;
    }

    @Override
    public void save(String attachFile, String content, String title, String studentCode, Byte enable) {
        concernRepository.saveConcern(attachFile,content,title,studentCode,enable);
    }
}
