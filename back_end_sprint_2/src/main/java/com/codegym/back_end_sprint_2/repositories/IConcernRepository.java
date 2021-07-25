package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Concern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IConcernRepository extends JpaRepository<Concern, Long> {

    //Get list of concern
    @Query(value = "SELECT * " +
            "FROM concern " +
            "INNER JOIN student " +
            "ON concern.student_code=student.code " +
            "INNER JOIN teacher " +
            "ON concern.student_code=teacher.code " +
            "WHERE concern.enable = 1 ", nativeQuery = true)
    Page<Concern> findAllConcern(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO concern (attach_file,content,title,notification_id,student_code,teacher_code, enable) " +
            "VALUE " +
            "(?1,?2,?3,?4,?5,?6,?7 ) ", nativeQuery = true)
    void saveConcern(String attachFile, String content, String title, Long notificationId, String studentCode, String teacherCode,Byte enable);
}
