package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IAnnouncementRepository extends JpaRepository<Announcement, Long> {

    //Create announcement
    @Modifying
    @Transactional
    @Query(value = " INSERT INTO announcement (attach_file,content,title,teacher_code, enable) " +
            "VALUE " +
            "(?1,?2,?3,?4,?5 ) ", nativeQuery = true)
    void saveAnnouncement(String attachFile, String content, String title, String teacherCode,Byte enable);
}
