package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IProjectRepository extends JpaRepository<Project,Long> {
    @Query(value = "SELECT * FROM project WHERE (status = 1 ) and enable = true ", nativeQuery = true)
    Page<Project> findAll(Pageable pageable);

    @Query(value = "SELECT * from project where id = ?1 ", nativeQuery = true)
    Optional<Project> findById(Long id);

    @Transactional
    @Modifying
    @Query(value = " UPDATE project SET enable = ?1 WHERE id = ?2 ", nativeQuery = true)
    void delete(Boolean enable, Long id);

    @Query(value = "SELECT * FROM project WHERE status = 0 ", nativeQuery = true)
    Page<Project> findAllApprove(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = " UPDATE project SET status = ?1 WHERE id = ?2 ", nativeQuery = true)
    void approveProject(Integer status, Long id);

    @Transactional
    @Modifying
    @Query(value = " UPDATE project SET status = ?1 WHERE id = ?2 ", nativeQuery = true)
    void notApproveProject(Integer status, Long id);
}
