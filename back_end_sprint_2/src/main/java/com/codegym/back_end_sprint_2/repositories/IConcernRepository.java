package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Concern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IConcernRepository extends JpaRepository<Concern, Long> {

    List<Concern> findAllByOrderByDateCreateDesc();

    @Query(value = "select teacher_code\n" +
            "from project\n" +
            "join team on project.team_id = team.id\n" +
            "where team.team_leader = ?1 ", nativeQuery = true)
    String getTeacherCode(String studentCode);

//    @Modifying
//    @Transactional
//    @Query(value = " INSERT INTO concern (attach_file,content,title,student_code, avatar, `name`, enable) " +
//            "VALUE " +
//            "(?1,?2,?3,?4,?5,?6,?7 ) ", nativeQuery = true)
//    void saveConcern(String attachFile, String content, String title, String studentCode, String avatar, String name, Byte enable, LocalDateTime dateCreate);
}
