package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IStudentTeacherRepository extends JpaRepository<Student,String> {
    @Modifying
    @Query(value ="INSERT INTO student ( `address`, `date_of_birth`, `email`, `enable`" +
            ", `gender`, `name`, `phone`, `status`)" +
            " VALUES (?1, ?2, ?3, ?4, ?5,?6 ,?7, ?8 ) " , nativeQuery = true)
    void createStudent(String address,String dateOfBirth,String email,Boolean enable,
                    String gender,String name,String phone,Boolean status);
//
//    @Modifying
//    @Query(value ="INSERT INTO teacher (`code`, `address`, `date_of_birth`, `email`, `enable`, `gender`, `education_id`, `faculty_id`, `teacher_name`, `teacher_code`) " +
//            " VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10 ) " , nativeQuery = true )
//    void createTeacher(String code, String dateOfBirth, String email, Boolean);
}
