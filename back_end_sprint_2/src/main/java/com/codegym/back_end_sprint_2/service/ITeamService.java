package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Project;
import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.model.entities.TeamDto;

import java.util.List;
import java.util.Optional;

public interface ITeamService {

    List<Team> findAll();


    Optional<Team> findById(Long id);

    Team save(Team team);


    public Team teamMapping(TeamDto teamDto);

    public List<Student> searchTeamRegistration(String search);
}
