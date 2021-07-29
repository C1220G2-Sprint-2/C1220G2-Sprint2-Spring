package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.config.MailConfig;
import com.codegym.back_end_sprint_2.model.entities.*;
import com.codegym.back_end_sprint_2.repositories.IProjectRepository;
import com.codegym.back_end_sprint_2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IProjectService projectService;
    @Autowired
    private IMailService mailService;
    @Autowired
    private ProjectService iProjectService;
    @Autowired
    private IProjectRepository projectRepository;
    @Autowired
    private ITeamService teamService;
    @Autowired
    private JavaMailSender mailSender;
//    @Autowired ProjectService

    @GetMapping("/listStudent")
    public ResponseEntity<List<Student>> listMeetingRoom() {
        List<Student> list = studentService.findAllJpa();
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
            return new ResponseEntity<>(HttpStatus.FOUND);
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
        mailService.emailToTeacher(newProject);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }
    @GetMapping("/findByTeam")
    public ResponseEntity<Project> findByTeam(@RequestParam(value = "teamId") Long id) {
        Project project = projectService.findByTeam(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

// Code a Phuc ------------------------------------------------------------

    @GetMapping()
    public List<Project> getListProject() {
        return iProjectService.findAll();
    }
    @GetMapping("/detail/{id}")
    public Project findById(@PathVariable Long id){
        return iProjectService.findById(id);
    }
    @PutMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestBody Project project) {
        iProjectService.delete(false, id);
    }
    @GetMapping("/approve")
    public List<Project> getListProjectApprove() {
        return projectRepository.findAllApprove();
    }
    @PutMapping("approve/{id}")
    public void approveProject(@PathVariable Long id, @RequestBody Project project) throws MessagingException {
        iProjectService.approveProject(true, id);
        System.out.println(project.getTeam().getId());
        String[] email = teamService.findStudentGroupById(project.getTeam().getId());
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        boolean multipart = true;
        String htmlMsg = "Đề tài của bạn được phê duyệt";
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart, "utf-8");
        mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
        helper.setTo(email);
        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("Đề tài của bạn đã được phê duyệt");
        this.mailSender.send(mimeMessage);
    }
    @PutMapping("notApprove/{id}")
    public void notApproveProject(@PathVariable Long id, @RequestBody Project project) throws MessagingException {
        iProjectService.notApproveProject(false, id);
        System.out.println(project.getTeam().getId());
        String[] email = teamService.findStudentGroupById(project.getTeam().getId());
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        boolean multipart = true;
        String htmlMsg = "Đề tài của bạn không được phê duyệt";
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart, "utf-8");
        mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
        helper.setTo(email);
        helper.addCc(MailConfig.FRIEND_EMAIL);
        helper.setSubject("Đề tài của bạn không được phê duyệt");
        this.mailSender.send(mimeMessage);
    }
    @GetMapping("/search/{keyword}")
    public List<Project> listSearch(@PathVariable String keyword){
        return iProjectService.searchProject(keyword);
    }
// Code a Phuc ------------------------------------------------------------
}
