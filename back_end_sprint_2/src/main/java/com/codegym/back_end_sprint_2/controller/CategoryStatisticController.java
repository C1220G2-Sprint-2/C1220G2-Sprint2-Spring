package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.entities.ICategoryStatistic;
import com.codegym.back_end_sprint_2.service.ICategoryStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/category-statistic")
public class CategoryStatisticController {
    @Autowired
    private ICategoryStatisticService categoryStatisticService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ICategoryStatistic> getCategoryStatisticList() {
        return categoryStatisticService.getCategoryStatistic();
    }

    @GetMapping("/passed-projects")
    @ResponseStatus(HttpStatus.OK)
    public int getNumberOfPassedProjects() {
        return categoryStatisticService.getNumberOfPassedProjects();
    }

    @GetMapping("/pending-projects")
    @ResponseStatus(HttpStatus.OK)
    public int getNumberOfPendingProjects() {
        return categoryStatisticService.getNumberOfPendingProjects();
    }
}
