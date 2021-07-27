package com.codegym.back_end_sprint_2.repository;

import com.codegym.back_end_sprint_2.model.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByNameContaining(String name);
}
