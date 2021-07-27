package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import com.codegym.back_end_sprint_2.model.dto.ProgressDto;
import com.codegym.back_end_sprint_2.model.dto.ProgressStudentDto;
import com.codegym.back_end_sprint_2.model.dto.ProjectDto;
import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Teacher;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.repositories.ITeacherRepository;
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
    @Autowired
    private ITeacherRepository teacherRepository;

    @Override
    public List<ProgressDto> findAll() {
        List<ProgressDto> progressDtoList = new ArrayList<>();
        List<Project> projectList = projectRepository.findAll();
        for (Project project : projectList) {
            progressDtoList.add(new ProgressDto(project.getId(), project.getTeam().getName(), project.getName(), project.getTeam().getNoOfMember()));
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
    public List<ProgressDto> searchByName(String name) {
        List<ProgressDto> progressDtoList = new ArrayList<>();
        List<Project> projectList = projectRepository.findByNameContaining(name);
        System.out.println(projectList.toString());
        for (Project project : projectList) {
            progressDtoList.add(new ProgressDto(project.getId(), project.getTeam().getName(), project.getName(), project.getTeam().getNoOfMember()));
        }
        return progressDtoList;
    }

    @Override
    public List<ProgressStudentDto> findStudentByIdGroup(Long projectId) {
        List<ProgressStudentDto> progressStudentDtos = new ArrayList<>();
        Project project = projectRepository.findById(projectId).orElse(null);
        assert project != null;
        Team team = project.getTeam();
        List<Student> studentList = team.getStudents();
        for (Student student : studentList) {
            progressStudentDtos.add(new ProgressStudentDto(student.getName(), student.getPhone(), student.getEmail(), student.getImage()));
        }
        return progressStudentDtos;
    }

    @Override
    public ProjectDto findProjectDtoByID(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        assert project != null;
        return new ProjectDto(project.getId(), project.getName());
    }

    @Override
    public Teacher findTeacherByCode(String code) {
        return teacherRepository.findByCode(code);
    }
}
