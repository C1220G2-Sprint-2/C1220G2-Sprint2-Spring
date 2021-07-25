package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.ICategoryStatistic;
import com.codegym.back_end_sprint_2.repositories.CategoryStatisticRepository;
import com.codegym.back_end_sprint_2.service.ICategoryStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryStatisticServiceImpl implements ICategoryStatisticService {
    @Autowired
    private CategoryStatisticRepository categoryStatisticRepository;

    @Override
    public List<ICategoryStatistic> getCategoryStatistic() {
        return categoryStatisticRepository.getCategoryStatistic();
    }

    @Override
    public int getNumberOfPassedProjects() {
        return categoryStatisticRepository.getNumberOfPassedProjects();
    }

    @Override
    public int getNumberOfPendingProjects() {
        return categoryStatisticRepository.getNumberOfPendingProjects();
    }
}
