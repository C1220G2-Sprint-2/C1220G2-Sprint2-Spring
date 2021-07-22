package com.codegym.back_end_sprint_2.repository;

import com.codegym.back_end_sprint_2.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Modifying
    @Transactional
    @Query(value ="update student set `enable` = 0 where `code` = ?1 ;", nativeQuery = true)
    void deleteByCodeS(String code);

//    @Modifying
//    @Transactional
//    @Query(value ="insert into student(address, date_of_birth, email, `enable`, facebook, gender, group_status, image, `name`, phone, `status`, class_id, faculty_id, group_id) " +
//            "values " +
//            "(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14) ", nativeQuery=true)
//    void create(String abc, String s, String s1, int i, String s2, String a, double v, String s3, String aka, String s4, int i1, int i2, int i3, int i4);

}
