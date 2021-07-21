package com.codegym.back_end_sprint_2.service.impl;

import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.model.entities.TeamDto;
import com.codegym.back_end_sprint_2.repositories.TeamRipository;
import com.codegym.back_end_sprint_2.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    private TeamRipository teamRipository;
    @Override
    public List<Team> findAll() {
        return teamRipository.findAll();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return teamRipository.findById(id);
    }

    @Override
    public Team save(Team team) {
        return teamRipository.save(team);
    }

    @Override
    public void deleteById(Long idDelete) {
    teamRipository.deleteById(idDelete);
    }

    public Team teamMapping(TeamDto teamDto) {
        Team team= new Team();
        team.setEnable(true);
        team.setName(teamDto.getName());
        team.setTeamLeader(teamDto.getTeamLeader());
        return team;
    }
}
