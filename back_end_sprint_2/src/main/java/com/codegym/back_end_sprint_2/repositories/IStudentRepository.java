package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student,String> {

    Student findByCode(String code);

    @Query(value = " select *\n" +
            "from student\n" +
            " inner join class on student.class_id = class.class_id " +
            "where code like %?1% or class.class_name like %?1% or `name` like %?1% ", nativeQuery = true)
     List<Student> searchTeamRegistration(String search);

    Optional<Student> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value ="update student set `enable` = 0 where `code` = ?1 ;", nativeQuery = true)
    void deleteByCodeS(String code);

    @Modifying
    @Transactional
    @Query(value ="update student set status = 0 where `code` = ?1 ;", nativeQuery = true)
    void block(String code);
}
