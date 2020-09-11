package com.home.diana.controller;

import com.home.diana.entity.Team;
import com.home.diana.service.TeamService;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet("/teamlist")
public class TeamListServlet implements Servlet {

    private TeamService teamService = new TeamService();

    public void init(ServletConfig var1) {
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, java.io.IOException {

        List<Team> teamList = teamService.findAll();

        request.setAttribute("teams", teamList);

        request.getRequestDispatcher("team/team-list.jsp").forward(request, response);
    }

    public void destroy() {
    }

    public String getServletInfo() {
        return "";
    }

    public ServletConfig getServletConfig() {
        return null;
    }
}
