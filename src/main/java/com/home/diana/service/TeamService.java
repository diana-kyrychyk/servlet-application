package com.home.diana.service;

import com.home.diana.dao.TeamDAO;
import com.home.diana.entity.Team;

import java.util.List;

public class TeamService {

    private TeamDAO teamDAO = new TeamDAO();

    public void create(Team team) {
        teamDAO.create(team);
    }

    public void update(Team team) {
        teamDAO.update(team);
    }

    public List<Team> findAll() {
        return teamDAO.findAll();
    }

    public Team findById(int id){
        return teamDAO.findById(id);
    }

}
