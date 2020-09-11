package com.home.diana.controller;

import com.home.diana.entity.Team;
import com.home.diana.entity.User;
import com.home.diana.service.TeamService;
import com.home.diana.service.UserService;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.nonNull;

@WebServlet("/user-edit")
public class UserEditServlet extends HttpServlet {

    private UserService userService = new UserService();
    private TeamService teamService = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = null;
        if (nonNull(id)) {
            user = userService.findById(Integer.valueOf(id));
        } else {
            user = new User();
        }

        List<Team> teams = teamService.findAll();

        List<Integer> userTeams = new ArrayList<>(Arrays.asList(3, 6));

        req.setAttribute("teams", teams);
        req.setAttribute("userTeams", userTeams);
        req.setAttribute("user", user);
        req.getRequestDispatcher("user/user-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName  = req.getParameter("firstName");
        String secondName  = req.getParameter("secondName");
        String login  = req.getParameter("login");
        String idStr  = req.getParameter("id");
        Integer id = nonNull(idStr) && !idStr.isEmpty() ? Integer.valueOf(idStr) : null;
        String[] selectedTeamsNames = req.getParameterValues("teams");

        User user = new User(id, firstName, secondName, login);

        if(nonNull(id)){
            userService.update(user);
        } else {
            userService.create(user);
        }

        req.setAttribute("message", "Team is created succesfully");

        req.getRequestDispatcher("userlist").forward(req, resp);
    }

    public void destroy(){ }

    public String getServletInfo() { 
	    return "";
    }

    public ServletConfig getServletConfig() { 
	    return null;
    }
}
