package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.dto.DtoTeam;

import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.model.entities.TeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITeamService {


    void saveTeam(Long id);

    Page<DtoTeam> findAllTeam(Pageable pageable);

    DtoTeam findByIdTeam(Long id);


    List<Team> findAll();

    Optional<Team> findById(Long id);

    Team save(Team team);



    public Team teamMapping(TeamDto teamDto);

    public List<Student> searchTeamRegistration(String search);

    String[] findStudentGroupById(Long id);


}
