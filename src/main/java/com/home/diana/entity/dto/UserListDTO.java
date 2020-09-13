package com.home.diana.entity.dto;

import com.home.diana.entity.Team;

import java.util.List;

public class UserListDTO {

    private Integer id;
    private String firstName;
    private String secondName;
    private String login;

    private List<Team> teams;


    public UserListDTO(Integer id, String firstName, String secondName, String login, List<Team> teams) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.teams = teams;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLogin() {
        return login;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
