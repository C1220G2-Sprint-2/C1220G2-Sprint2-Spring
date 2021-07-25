package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.entities.ITeacherStatistic;
import com.codegym.back_end_sprint_2.service.ITeacherStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/teacher-statistic")
public class TeacherStatisticController {
    @Autowired
    private ITeacherStatisticService teacherStatisticService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ITeacherStatistic> getTeacherStatistic() {
        return teacherStatisticService.getTeacherStatistic();
    }

    @GetMapping("/number-of-teachers")
    @ResponseStatus(HttpStatus.OK)
    public int getNumberOfTeachers() {
        return teacherStatisticService.getNumberOfTeachers();
    }
}
