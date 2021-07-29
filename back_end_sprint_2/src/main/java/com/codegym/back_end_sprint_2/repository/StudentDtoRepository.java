package com.codegym.back_end_sprint_2.repository;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDtoRepository extends JpaRepository<StudentDto, String> {


    @Query(value = "select student.`code` , student.address, class.class_name as class_student,date_of_birth, student.email, student.`enable`, " +
            "student.facebook ,  faculties.faculty_name as faculty,gender, student.image, student.`name`, student.phone,  student.`status` , team.`name` as team  " +
            "            from student " +
            "            inner join class on class.class_id = student.class_id " +
            "            inner join faculties on faculties.faculty_id = student.faculty_id " +
            "            inner join team on team.id = student.group_id " +
            "            where (class.class_name like concat('%',?1,'%')  " +
            "            or faculties.faculty_name like concat('%',?1,'%') " +
            "            or student.`code` like concat('%',?1,'%') " +
            "            or student.`name` like concat('%',?1,'%') " +
            "            or ?1 is null) and student.`enable` = true " +
            "            order by student.`code` asc ", nativeQuery = true)
    List<StudentDto> listSearch(String keyword);

    @Query(value = "select student.`code` , student.address, class.class_id as class_student,date_of_birth, student.email, student.`enable`, student.facebook" +
            " ,  faculties.faculty_id as faculty,student.gender, student.image, student.`name`, student.phone,  student.`status` , team.`name` as team  " +
            "from student " +
            "inner join class on class.class_id = student.class_id " +
            "inner join faculties on faculties.faculty_id = student.faculty_id " +
            "inner join team on team.id = student.group_id " +
            "where student.`code` = ?1", nativeQuery = true)
    StudentDto findQueryById(String code);

    @Query(value = "select student.`code` , student.address, class.class_name as class_student,date_of_birth, student.email, student.`enable`, " +
            "student.facebook ,  faculties.faculty_name as faculty,gender, student.image, student.`name`, student.phone,  student.`status` , team.`name` as team  " +
            "            from student " +
            "            inner join class on class.class_id = student.class_id " +
            "            inner join faculties on faculties.faculty_id = student.faculty_id " +
            "            inner join team on team.id = student.group_id " +
            "            where team.`name` = ?1  " +
            "            and student.`status` = true ", nativeQuery = true)
    List<StudentDto> findStudentsByTeam(String team);

}
