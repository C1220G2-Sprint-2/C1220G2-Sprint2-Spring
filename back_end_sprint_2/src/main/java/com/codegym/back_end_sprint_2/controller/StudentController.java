package com.codegym.back_end_sprint_2.controller;


import com.codegym.back_end_sprint_2.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.codegym.back_end_sprint_2.service.StudentDtoService;
import com.codegym.back_end_sprint_2.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/student")
public class StudentController {


    @Autowired
    StudentService studentService;
    @Autowired
    StudentDtoService studentDtoService;

    @GetMapping("/search")
    public List<StudentDto> findAll(@RequestParam(name = "keyword", required = false) String keyword){
    return studentService.listSearch(keyword);
    }

    @PostMapping()
    public void create(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
    }
    @GetMapping("/{code}")
    public StudentDto findById(@PathVariable String code){
        return studentDtoService.findQueryById(code);
    }
    @PutMapping("/{code}")
    public void edit(@PathVariable String code, @RequestBody StudentDto studentDto){
        studentService.save(studentDto);
    }


}
