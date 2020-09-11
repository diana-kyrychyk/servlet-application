package com.home.diana.dao;

import com.home.diana.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMap {

    private static List<User> users = new ArrayList<>();

    public static void create(User user) {
        users.add(user);
    }

    public static List<User> findAll() {
        return new ArrayList<>(users);
    }

}

