package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.dto.ProgressDto;
import com.codegym.back_end_sprint_2.model.dto.ProgressStudentDto;
import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.repositories.ProjectRepository;
import com.codegym.back_end_sprint_2.repository.StudentRepository;
import com.codegym.back_end_sprint_2.service.IProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgressServiceImpl implements IProgressService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<ProgressDto> findAll() {
        List<ProgressDto> progressDtoList = new ArrayList<>();
        List<Project> projectList = projectRepository.findAll();
        for (Project project : projectList) {
            progressDtoList.add(new ProgressDto(project.getId(), project.getTeam().getName(), project.getContent(), project.getTeam().getNoOfMember()));
        }
        return progressDtoList;
    }

    @Override
    public List<ProgressStudentDto> findAllStudent() {
        List<ProgressStudentDto> progressStudentDtos = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            progressStudentDtos.add(new ProgressStudentDto(student.getName(), student.getPhone(), student.getEmail(), student.getImage()));
        }
        return progressStudentDtos;
    }

    @Override
    public List<Project> searchByName() {
        return null;
    }
}
