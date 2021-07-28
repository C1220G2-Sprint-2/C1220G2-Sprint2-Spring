package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Concern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IConcernRepository extends JpaRepository<Concern, Long> {

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO concern (attach_file,content,title,student_code, avatar, `name`, enable) " +
            "VALUE " +
            "(?1,?2,?3,?4,?5,?6,?7 ) ", nativeQuery = true)
    void saveConcern(String attachFile, String content, String title, String studentCode,String avatar, String name, Byte enable);
}
