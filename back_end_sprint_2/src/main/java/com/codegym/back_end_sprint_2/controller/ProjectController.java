package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.entities.*;
import com.codegym.back_end_sprint_2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IProjectService projectService;
    @Autowired
    private ITeamService teamService;
    @Autowired
    private IMailService mailService;

    @GetMapping("/listStudent")
    public ResponseEntity<List<Student>> listMeetingRoom() {
        List<Student> list = studentService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> listCategory() {
        List<Category> list = categoryService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/listTeacher")
    public ResponseEntity<List<Teacher>> listTeacher() {
        List<Teacher> list = teacherService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/listProject")
    public ResponseEntity<List<Project>> listProject() {
        List<Project> list = projectService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(
            @RequestParam(value = "codeStudent") String codeStudent
    ) {
        Student student = studentService.findByCode(codeStudent);
        if (student == null) {
            return   new ResponseEntity<>( HttpStatus.FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/postProject")
    public ResponseEntity<Project> save(@RequestBody ProjectDtoHuy project) throws MessagingException {

        Project newProject = new Project();
        newProject.setCategory(categoryService.findByName(project.getCategory()));
        newProject.setTeacher(teacherService.findByName(project.getTeacher()));
        newProject.setContent(project.getContent());
        newProject.setName(project.getName());
        newProject.setDescription(project.getDescription());
        newProject.setImage(project.getImage());
        newProject.setEnable(true);
        newProject.setTeam(project.getTeam());
        newProject.setRegisterDate(LocalDate.now().toString());
        projectService.save(newProject);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @GetMapping("/findByTeam")
    public ResponseEntity<Project> findByTeam(@RequestParam(value = "teamId") Long id) {
        Project project = projectService.findByTeam(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

//    @GetMapping("/studentOnTeam")
//    public ResponseEntity<Student> getStudent(
//            @RequestParam(value = "codeStudent") String codeStudent
//    ) {
//        Student student = studentService.findByCode(codeStudent);
//        if (student == null) {
//            return   new ResponseEntity<>( HttpStatus.FOUND);
//        }
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }
}
