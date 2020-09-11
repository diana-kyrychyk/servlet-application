package com.home.diana.service;

import com.home.diana.dao.UserDAO;
import com.home.diana.entity.Team;
import com.home.diana.entity.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public void update(User user) {
        userDAO.update(user);
    }

    public void create(User user) {
        userDAO.create(user);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findById(int id){
        return userDAO.findById(id);
    }

}
