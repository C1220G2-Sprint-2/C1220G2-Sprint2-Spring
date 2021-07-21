package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.Dto.DtoTeam;
import com.codegym.back_end_sprint_2.model.entities.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRipository extends JpaRepository<Team, Long> {
//    @Query(value = "select team.`name`,team.team_leader,project.deadline,project.`status` from team join project on team.id = project.team_id",nativeQuery = true)
//    List<Team> findAllTeam();
}
