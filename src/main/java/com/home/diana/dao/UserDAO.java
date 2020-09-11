package com.home.diana.dao;

import com.home.diana.entity.Team;
import com.home.diana.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void create(User user) {
        String insertUser =
                "insert into users (first_name, second_name) " +
                        "values (?, ?);";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertUser);) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        String updateUserQuery =
                "update users " +
                        "set " +
                        "first_name = ?, " +
                        "second_name = ?, " +
                        "login = ? " +
                        "where id = ? ;";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateUserQuery);) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findById(int userID) {
        String findByIdQuery = "SELECT id, first_name, second_name, login " +
                "FROM users " +
                "WHERE id = ? ";

       User user = null;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(findByIdQuery);) {

            preparedStatement.setInt(1, userID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String login = resultSet.getString("login");
                int id = resultSet.getInt("id");
                user = new User(id, firstName, secondName, login);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> findAll() {
        String selectUsers =
                "select id, first_name, second_name, login FROM users ;";

        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(selectUsers);
            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String nameSecond = resultSet.getString("second_name");
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                User user = new User(id, name, nameSecond, login);
                users.add(user);
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}

