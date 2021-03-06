package com.codegym.back_end_sprint_2.config;

import com.codegym.back_end_sprint_2.model.entities.*;
import com.codegym.back_end_sprint_2.repositories.CategoryRepository;
import com.codegym.back_end_sprint_2.repository.IRoleRepository;
import com.codegym.back_end_sprint_2.repository.IUserRepository;
import com.codegym.back_end_sprint_2.repository.TeamRepository;
import com.codegym.back_end_sprint_2.until.EncryptPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TeamRepository teamRepository;


    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_TEACHER = "ROLE_TEACHER";
    private static final String ROLE_STUDENT = "ROLE_STUDENT";
    private static final String USERNAME_ADMIN = "AM000000";
    private static final String SECRET = "123456";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //        Create role
        if (roleRepository.findByName(ROLE_ADMIN) == null) {
            roleRepository.save(new Role(ROLE_ADMIN));
        }
        if (roleRepository.findByName(ROLE_TEACHER) == null) {
            roleRepository.save(new Role(ROLE_TEACHER));
        }
        if (roleRepository.findByName(ROLE_STUDENT) == null) {
            roleRepository.save(new Role(ROLE_STUDENT));
        }

        // Create Account Admin
        if (!userRepository.findByUsername(USERNAME_ADMIN).isPresent()) {
            User admin = new User();
            admin.setUsername(USERNAME_ADMIN);
            admin.setStatus(true);
            admin.setPassword(EncryptPasswordUtils.EncodePassword(SECRET));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName(ROLE_ADMIN));
            roles.add(roleRepository.findByName(ROLE_TEACHER));
            admin.setRoles(roles);
            userRepository.save(admin);
        }
        // create Category
        if (categoryRepository.findByName("C??ng ngh??? th??ng tin") == null) {
            categoryRepository.save(new Category("C??ng ngh??? th??ng tin"));
        }
        if (categoryRepository.findByName("L????ng th???c th???c ph???m") == null) {
            categoryRepository.save(new Category("L????ng th???c th???c ph???m"));
        }
        if (categoryRepository.findByName("T??i ch??nh ng??n h??ng") == null) {
            categoryRepository.save(new Category("T??i ch??nh ng??n h??ng"));
        }
        if (categoryRepository.findByName("Lu???t") == null) {
            categoryRepository.save(new Category("Lu???t"));
        }
        if (categoryRepository.findByName("N??ng - L??m -Th???y S???n") == null) {
            categoryRepository.save(new Category("N??ng - L??m -Th???y S???n"));
        }
        if (categoryRepository.findByName("Kinh t??? gi??o d???c") == null) {
            categoryRepository.save(new Category("Kinh t??? gi??o d???c"));
        }
        if (!teamRepository.findById(1L).isPresent()) {
            teamRepository.save(new Team(1L,"kh??ng c?? nh??m","kh??ng c?? team Leader",true));
        }
    }
}
