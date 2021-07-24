package com.codegym.back_end_sprint_2.repository;

import com.codegym.back_end_sprint_2.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    User findByStudentId(Long studentId);
    User findByTeacherId(Long teacherId);
    Optional<User> findByStudent_Email(String email);
    Optional<User> findByTeacher_Email(String email);

    @Modifying
    @Transactional
    @Query(value = " UPDATE users " +
            "SET users.password = ?1 " +
            "WHERE users.username = ?2 ", nativeQuery = true)
    void updateUserPassword(String password, String username);

}
