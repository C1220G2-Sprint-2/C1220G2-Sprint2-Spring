package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.ConcernDto;
import com.codegym.back_end_sprint_2.model.entities.Concern;
import com.codegym.back_end_sprint_2.repositories.IConcernRepository;
import com.codegym.back_end_sprint_2.repositories.IStudentRepository;
import com.codegym.back_end_sprint_2.repositories.ITeacherRepository;
import com.codegym.back_end_sprint_2.service.IConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConcernServiceImpl implements IConcernService {

    @Autowired
    private IConcernRepository concernRepository;
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private ITeacherRepository teacherRepository;

    @Override
    public List<ConcernDto> findAll(Long noOfPage) {
        List<ConcernDto> concernDtoList = new ArrayList<>();
        List<Concern> concernList = concernRepository.findAllByOrderByDateCreateDesc();
        int length = 0;
        for (Concern concern : concernList) {
            if (length == noOfPage) {
                break;
            }
            concernDtoList.add(new ConcernDto(concern.getId(), concern.getTitle(), concern.getContent(),
                    concern.getStudent().getCode(), concern.getAttachFile(),concern.getAvatar(),concern.getName(),concern.getDateCreate()));
            length++;
        }
        return concernDtoList;
    }

    @Override
    public void save(ConcernDto concernDto) {
        concernRepository.save(new Concern(concernDto.getTitle(),concernDto.getContent(),concernDto.getAttachFile(),
                true,concernDto.getAvatar(),concernDto.getName(),LocalDateTime.now(),
                studentRepository.findByCode(concernDto.getStudentCode())));
    }

    @Override
    public int maxLengthListReview() {
        return concernRepository.findAll().size();
    }

    @Override
    public String getTeacherCode(String studentCode) {
        return concernRepository.getTeacherCode(studentCode);
    }
}
