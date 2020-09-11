package com.home.diana.dao;

import com.home.diana.entity.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {

    public void create(Team team) {
        String insertTeam =
                "insert into teams (name) " +
                        "values (?);";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertTeam);) {
            preparedStatement.setString(1, team.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(Team team) {
        String updateTeamQuery =
                "update teams " +
                        "set name = ? " +
                        "where id = ? ;";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateTeamQuery);) {
            preparedStatement.setString(1, team.getName());
            preparedStatement.setInt(2, team.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Team> findAll() {
        String selectTeamsQuery =
                "SELECT id, name FROM teams ;";

        List<Team> teams = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(selectTeamsQuery);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                Team team = new Team(id, name);
                teams.add(team);
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    public Team findById(int teamID) {
        String findByIdQuery = "SELECT id, name " +
                "FROM teams " +
                "WHERE id = ? ";

        Team team = null;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(findByIdQuery);) {

            preparedStatement.setInt(1, teamID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                team = new Team(id, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

}

