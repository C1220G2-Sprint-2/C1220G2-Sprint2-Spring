package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.dto.ITeacherStatistic;
import com.codegym.back_end_sprint_2.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeacherStatisticRepository extends JpaRepository<Teacher, String> {
    @Query(value="select p.teacher_code as teacher_code, t.teacher_name as teacher_name, count(p.teacher_code) as number_of_registers\n" +
            "from project p\n" +
            "inner join teacher t on (p.teacher_code = t.code)\n" +
            "group by (p.teacher_code)\n" +
            "order by (p.teacher_code);",
            nativeQuery = true)
    List<ITeacherStatistic> getTeacherStatistic();

    @Query(value="select count(*) from teacher;",
            nativeQuery = true)
    int getNumberOfTeachers();
}
