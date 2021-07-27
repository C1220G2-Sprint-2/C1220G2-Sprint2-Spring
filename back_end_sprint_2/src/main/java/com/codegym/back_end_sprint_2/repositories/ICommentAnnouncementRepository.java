package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.AnnounceComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICommentAnnouncementRepository extends JpaRepository<AnnounceComment, Long> {

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO announce_comment (content, announcement_id, student_code, teacher_code, attach_file, avatar, `name`) " +
            "VALUE " +
            "(?1,?2,?3,?4,?5,?6,?7 ) ", nativeQuery = true)
    void saveCommentConcern(String content, Long announcementId, String studentCode, String teacherCode,String attachFile,String avatar, String name);
}
