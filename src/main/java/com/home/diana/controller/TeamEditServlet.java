package com.home.diana.controller;

import com.home.diana.entity.Team;
import com.home.diana.service.TeamService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebServlet("/edit-team")
public class TeamEditServlet extends HttpServlet {

    private TeamService teamService = new TeamService();

	public void init(ServletConfig var1) {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Team team = null;
        if (nonNull(id)) {
            team = teamService.findById(Integer.valueOf(id));
        } else {
            team = new Team();
        }

        req.setAttribute("team", team);
        req.getRequestDispatcher("team/team-edit.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        String name  = request.getParameter("name");
        String idStr  = request.getParameter("id");
        Integer id = nonNull(idStr) && !idStr.isEmpty() ? Integer.valueOf(idStr) : null;

        Team team = new Team(id, name);

        if(nonNull(id)){
            teamService.update(team);
        } else {
            teamService.create(team);
        }

        request.setAttribute("message", "Team is created succesfully");

        request.getRequestDispatcher("index.html").forward(request, response);
    }    

    public void destroy(){ }

    public String getServletInfo() { 
	    return "";
    }

    public ServletConfig getServletConfig() { 
	    return null;
    }
}
