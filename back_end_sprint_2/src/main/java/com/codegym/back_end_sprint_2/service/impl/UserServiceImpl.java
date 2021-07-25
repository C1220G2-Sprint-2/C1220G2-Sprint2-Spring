package com.codegym.back_end_sprint_2.service.impl;
import com.codegym.back_end_sprint_2.model.entities.User;
import com.codegym.back_end_sprint_2.repository.IUserRepository;
import com.codegym.back_end_sprint_2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public void updateUserPassword(String password, String username) {
        iUserRepository.updateUserPassword(password,username);
    }

    @Override
    public User findByStudentEmail(String email) {
        return iUserRepository.findByStudent_Email(email).orElse(null);
    }

    @Override
    public User findByTeacherEmail(String email) {
        return iUserRepository.findByTeacher_Email(email).orElse(null);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return iUserRepository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String name) {
        return iUserRepository.findByUsername(name).orElse(null);
    }
}
