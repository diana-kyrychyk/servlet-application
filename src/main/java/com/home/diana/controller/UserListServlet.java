package com.home.diana.controller;

import com.home.diana.entity.User;
import com.home.diana.entity.dto.UserListDTO;
import com.home.diana.service.UserService;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet("/user-list")
public class UserListServlet implements Servlet {

    private UserService userService = new UserService();

	public void init(ServletConfig var1) {
	}

    public void service(ServletRequest request, ServletResponse response) throws ServletException, java.io.IOException {

        List<UserListDTO> userList = userService.findAllDTO();

        request.setAttribute("users", userList);

        request.getRequestDispatcher("user/user-list.jsp").forward(request, response);
    }    

    public void destroy(){
    }

    public String getServletInfo() { 
	    return "";
    }

    public ServletConfig getServletConfig() { 
	    return null;
    }
}
