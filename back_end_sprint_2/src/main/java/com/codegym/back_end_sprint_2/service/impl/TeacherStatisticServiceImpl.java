package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.ITeacherStatistic;
import com.codegym.back_end_sprint_2.repositories.TeacherStatisticRepository;
import com.codegym.back_end_sprint_2.service.ITeacherStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherStatisticServiceImpl implements ITeacherStatisticService {
    @Autowired
    private TeacherStatisticRepository teacherStatisticRepository;

    @Override
    public List<ITeacherStatistic> getTeacherStatistic() {
        return this.teacherStatisticRepository.getTeacherStatistic();
    }

    @Override
    public int getNumberOfTeachers() {
        return this.teacherStatisticRepository.getNumberOfTeachers();
    }
}
