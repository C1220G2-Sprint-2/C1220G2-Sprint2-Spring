package com.codegym.back_end_sprint_2.repository;

import com.codegym.back_end_sprint_2.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value="select teacher.teacher_code, teacher.address , teacher.date_of_birth, teacher.email, teacher.`enable`, teacher.facebook, " +
            "            teacher.gender, teacher.image, teacher.teacher_name, teacher.phone, teacher.twitter, teacher.education_id, teacher.faculty_id " +
            "            from teacher " +
            "            inner join project on project.teacher_code = teacher.teacher_code " +
            "            inner join team on project.team_id = team.id " +
            "            where team.`name` = ?1 " +
            "            group by teacher.teacher_code;", nativeQuery = true)
    Teacher findTeacherByTeam(String team);

}
