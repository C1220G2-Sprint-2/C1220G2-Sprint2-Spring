package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//code from SangLd
@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByCode(String code);
}
//end code from sang
