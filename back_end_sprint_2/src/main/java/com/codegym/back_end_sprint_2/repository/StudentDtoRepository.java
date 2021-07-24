package com.codegym.back_end_sprint_2.repository;

import com.codegym.back_end_sprint_2.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDtoRepository extends JpaRepository<StudentDto, String> {


    @Query(value = "select `code` , address, class.class_name as class_student,date_of_birth, email, `enable`, facebook ,  faculties.faculty_name as faculty,gender, image, `name`, phone,  `status` , group_id as team  " +
            "from student " +
            "inner join class on class.class_id = student.class_id " +
            "inner join faculties on faculties.faculty_id = student.faculty_id " +
            "where (class.class_name like concat('%',?1,'%') " +
            " or faculties.faculty_name like concat('%',?1,'%') " +
            "    or student.`code` like concat('%',?1,'%') " +
            "    or student.`name` like concat('%',?1,'%') " +
            "    or ?1 is null) and student.`enable` = true ;", nativeQuery =true)
    List<StudentDto> listSearch(String keyword);

    @Query(value = "select `code` , address, class.class_id as class_student,date_of_birth, email, `enable`, facebook ,  faculties.faculty_id as faculty,gender, image, `name`, phone,  `status` , group_id as team  " +
            "from student " +
            "inner join class on class.class_id = student.class_id " +
            "inner join faculties on faculties.faculty_id = student.faculty_id " +
            "where `code` = ?1" ,nativeQuery = true)
    StudentDto findQueryById(String code);
}
