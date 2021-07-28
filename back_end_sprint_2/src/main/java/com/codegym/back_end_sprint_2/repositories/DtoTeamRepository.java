package com.codegym.back_end_sprint_2.repositories;

import com.codegym.back_end_sprint_2.dto.DtoTeam;
import com.codegym.back_end_sprint_2.model.entities.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DtoTeamRepository extends JpaRepository<DtoTeam,Long> {


    @Query(value = "select team.id,team.`name`,team.team_leader,team.enable,project.deadline,project.`status` " +
            "from team " +
            "left join project " +
            "on team.id = project.team_id",nativeQuery = true)
    Page<DtoTeam> findAllTeam(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update team set team.enable= 0 where team.id=?1",nativeQuery = true)
    Team saveTeam(Long id);


    @Query(value = "select t.id,t.`name`,t.team_leader,t.`enable`,project.deadline,project.`status` \n" +
            "            from team t\n " +
            "            left join project \n " +
            "            on t.id = project.team_id\n " +
            " where  t.enable = 1 and (t.`name` like %?1% or project.deadline like %?1% or t.team_leader like %?1%)" +
            " group by id ",nativeQuery = true)
    List<DtoTeam> searchAll( String search);
}
