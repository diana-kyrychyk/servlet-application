package com.home.diana.service;

import com.home.diana.dao.UserDAO;
import com.home.diana.entity.Team;
import com.home.diana.entity.User;
import com.home.diana.entity.dto.UserListDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private UserDAO userDAO = new UserDAO();
    private TeamService teamService = new TeamService();

    public void update(User user, List<Integer> selectedTeams) {
        userDAO.update(user);
        userDAO.updateTeamsForUser(user.getId(), selectedTeams);
    }

    public void create(User user, List<Integer> selectedTeams) {
        userDAO.create(user);
        userDAO.updateTeamsForUser(user.getId(), selectedTeams);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public List<UserListDTO> findAllDTO() {
        List<User> users = userDAO.findAll();
        return users.stream()
                .map(user -> convertToDTO(user))
                .collect(Collectors.toList());
    }

    public User findById(int id){
        return userDAO.findById(id);
    }

    private UserListDTO convertToDTO(User user){
        List<Team> teams = teamService.findByUser(user.getId());
        return new UserListDTO(user.getId(), user.getFirstName(), user.getSecondName(), user.getLogin(), teams);
    }

}
