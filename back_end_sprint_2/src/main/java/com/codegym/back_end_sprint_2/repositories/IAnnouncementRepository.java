package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IAnnouncementRepository {

    //Get list of concern
    @Query(value = "SELECT * " +
            "FROM announcement " +
            "INNER JOIN teacher " +
            "ON announcement.student_code=teacher.code " +
            "WHERE announcement.enable = 1 ", nativeQuery = true)
    Page<Announcement> findAllAnnouncement(Pageable pageable);

    //Create announcement
    @Modifying
    @Transactional
    @Query(value = " INSERT INTO announcement (attach_file,content,title,notification_id,teacher_code, enable) " +
            "VALUE " +
            "(?1,?2,?3,?4,?5,?6) ", nativeQuery = true)
    void saveAnnouncement(String attachFile, String content, String title, Long notificationId, String teacherCode,Byte enable);
}
