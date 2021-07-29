package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.ConcernComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICommentConcernRepository extends JpaRepository<ConcernComment, Long> {

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO concern_comment (content, concern_id, student_code, teacher_code, attach_file, avatar, `name`) " +
            "VALUE " +
            "(?1,?2,?3,?4,?5,?6,?7 ) ", nativeQuery = true)
    void saveCommentConcern(String content, Long concernId, String studentCode, String teacherCode,String attachFile,String avatar, String name);

    @Query(value = " SELECT email " +
            "FROM student " +
            "JOIN concern ON student.`code` = concern.student_code " +
            "WHERE concern.id = ?1 ", nativeQuery = true)
    String getStudentEmail(Long concernId);
}
