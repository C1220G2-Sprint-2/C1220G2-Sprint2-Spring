package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.entities.*;

import javax.mail.MessagingException;

public interface IMailService {

    String  emailTeam(Student student, Team teamDto) throws MessagingException;
    public String emailCcTeamLeader(Student student, String check) throws MessagingException;
    public String emailToTeacher( Project project) throws MessagingException;
}
