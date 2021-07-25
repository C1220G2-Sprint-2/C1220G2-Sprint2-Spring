package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher,String> {

    Optional<Teacher> findByEmail(String email);

    @Query(value = "SELECT * FROM teacher " +
            "WHERE enable = 1 ", nativeQuery = true)
    List<Teacher> findAll();

    @Query(value ="SELECT * FROM teacher " +
            "WHERE teacher_code = ?1 AND enable = 1 ", nativeQuery = true)
    Optional<Teacher> findTeacherByCode(String code);

    @Query(value = "SELECT * FROM teacher " +
            "JOIN faculties ON teacher.faculty_id = faculties.faculty_id " +
            "WHERE teacher.enable = 1 " +
            "AND (teacher.teacher_code like %?1% " +
            "OR teacher.teacher_name like %?1% " +
            "OR teacher.email like %?1% " +
            "OR teacher.phone like %?1% " +
            "OR faculties.faculty_name like %?1%) ", nativeQuery = true)
    List<Teacher> searchTeacher(String keyWord);

}
