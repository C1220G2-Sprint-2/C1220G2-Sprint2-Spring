package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.User;

public interface IUserService {
    void updateUserPassword(String password, String username);
    User findByStudentEmail(String email);
    User findByTeacherEmail(String email);
    Boolean existsByUsername(String username);
    User findByUsername(String name);
}
