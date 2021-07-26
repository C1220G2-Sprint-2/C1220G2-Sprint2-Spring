package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.model.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//code by sang
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
//end code by sang
