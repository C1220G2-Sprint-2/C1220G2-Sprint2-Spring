package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectReponsitory extends JpaRepository<Project,Long> {
    @Query(value = " select * from project " +
            "        order by register_date desc ; ", nativeQuery = true)
    List<Project> findAll();
}
