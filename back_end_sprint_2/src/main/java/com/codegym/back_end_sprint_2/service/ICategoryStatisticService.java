package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.ICategoryStatistic;

import java.util.List;

public interface ICategoryStatisticService {
    List<ICategoryStatistic> getCategoryStatistic();
    int getNumberOfPassedProjects();
    int getNumberOfPendingProjects();

}
