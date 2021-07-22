package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    public Student findByCode(String code);

    @Query(value = " select *\n" +
            "from student\n" +
            "where code like %?1% or class_code like %?1% or `name` like %?1% ", nativeQuery = true)
     List<Student> searchTeamRegistration(String search);

}
