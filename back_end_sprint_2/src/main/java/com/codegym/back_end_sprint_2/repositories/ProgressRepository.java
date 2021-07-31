package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> getByProjectId(int projectId);

    Progress findByStatusAndProjectId(String status, int projectId);
}
