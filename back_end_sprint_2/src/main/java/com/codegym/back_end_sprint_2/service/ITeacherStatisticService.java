package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.ITeacherStatistic;

import java.util.List;

public interface ITeacherStatisticService {
    List<ITeacherStatistic> getTeacherStatistic();
    int getNumberOfTeachers();
}
