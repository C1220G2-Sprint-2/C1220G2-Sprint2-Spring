package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface ICommentReviewRepository extends JpaRepository<ReviewComment, Long> {

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO review_comment (content, student_code, avatar, `name`, review_id, date_create) " +
            "VALUE " +
            "(?1,?2,?3,?4,?5,?6,?7 ) ", nativeQuery = true)
    void saveReviewComment(String content, String studentCode, String avatar, String name, Long reviewId, LocalDateTime dateCreate);
}
