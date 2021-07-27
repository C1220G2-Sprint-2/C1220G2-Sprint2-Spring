package com.codegym.back_end_sprint_2.repository;

import com.codegym.back_end_sprint_2.model.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
