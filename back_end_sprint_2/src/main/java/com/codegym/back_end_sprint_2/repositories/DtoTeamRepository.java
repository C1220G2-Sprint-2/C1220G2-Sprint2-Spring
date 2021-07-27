package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.dto.DtoTeam;
import com.codegym.back_end_sprint_2.model.entities.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DtoTeamRepository extends JpaRepository<DtoTeam,Long> {

    @Query(value = "select team.id,team.`name`,team.team_leader,team.enable,project.deadline,project.`status` from team left join project on team.id = project.team_id",nativeQuery = true)
        Page<DtoTeam> findAllTeam(Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "update team set team.enable= 0 where team.id=?1",nativeQuery = true)
    Team saveTeam(Long id);

}
