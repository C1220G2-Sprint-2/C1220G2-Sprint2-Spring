package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.Student;

import com.codegym.back_end_sprint_2.model.entities.TeamDto;

import javax.mail.MessagingException;

public interface IMailService {

    String  emailTeam(Student student, TeamDto teamDto) throws MessagingException;
    public String emailCcTeamLeader(Student student, String check) throws MessagingException;
}
