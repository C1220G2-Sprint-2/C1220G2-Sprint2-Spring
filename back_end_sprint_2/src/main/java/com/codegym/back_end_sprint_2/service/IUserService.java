package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.User;
import org.springframework.data.jpa.repository.Query;

public interface IUserService {
    void updateUserPassword(String password, String username);
    User findByStudentEmail(String email);
    User findByTeacherEmail(String email);
    Boolean existsByUsername(String username);
    User findByUsername(String name);
    User findUserById(Long id);
}
