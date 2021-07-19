package com.codegym.back_end_sprint_2.service.impl;


import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.repositories.StudentRepository;
import com.codegym.back_end_sprint_2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByCode(String code) {
        return studentRepository.findByCode(code);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteByCode(String code) {
    }


}
