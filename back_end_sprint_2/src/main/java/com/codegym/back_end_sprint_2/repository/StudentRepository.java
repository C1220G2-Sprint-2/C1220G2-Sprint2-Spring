package com.codegym.back_end_sprint_2.repository;

import com.codegym.back_end_sprint_2.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Modifying
    @Transactional
    @Query(value ="update student set `enable` = 0 where `code` = ?1 ;", nativeQuery = true)
    void deleteByCodeS(String code);

    @Modifying
    @Transactional
    @Query(value ="update student set status = 0 where `code` = ?1 ;", nativeQuery = true)
    void block(String code);
    Optional<Student> findByEmail(String email);
}
