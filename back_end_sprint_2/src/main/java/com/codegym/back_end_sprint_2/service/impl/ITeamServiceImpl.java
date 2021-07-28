package com.codegym.back_end_sprint_2.service.impl;



import com.codegym.back_end_sprint_2.model.entities.Student;
import com.codegym.back_end_sprint_2.model.entities.Team;
import com.codegym.back_end_sprint_2.model.entities.TeamDto;
import com.codegym.back_end_sprint_2.repositories.IStudentRepository;


import com.codegym.back_end_sprint_2.dto.DtoTeam;

import com.codegym.back_end_sprint_2.repositories.DtoTeamRepository;
import com.codegym.back_end_sprint_2.repositories.ITeamRepository;

import com.codegym.back_end_sprint_2.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ITeamServiceImpl implements ITeamService {

    @Autowired
    private IStudentRepository studentRepository;
    @Autowired

    private ITeamRepository teamRepository;
    @Autowired
    private DtoTeamRepository dtoTeamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }


    @Override
    public Team saveTeam(Long id) {
         return dtoTeamRepository.saveTeam(id);
    }

    @Override
    public Page<DtoTeam> findAllTeam(Pageable pageable) {
        return dtoTeamRepository.findAllTeam(pageable);
    }

    @Override
    public DtoTeam findByIdTeam(Long id) {
        return dtoTeamRepository.findById(id).orElse(null);
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }



    public Team teamMapping(TeamDto teamDto) {
        Team team= new Team();
        team.setEnable(true);
        team.setName(teamDto.getName());
        team.setTeamLeader(teamDto.getTeamLeader());
        return team;
    }

    @Override
    public List<Student> searchTeamRegistration(String search) {
        return studentRepository.searchTeamRegistration(search);
    }



    public String[] findStudentGroupById(Long id) {
        return teamRepository.findStudentGroupById(id);
    }

    @Override
    public List<DtoTeam> searchAll(String search) {
        return dtoTeamRepository.searchAll(search);
    }

}
