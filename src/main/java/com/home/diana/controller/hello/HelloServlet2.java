package com.home.diana.controller.hello;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/hello2")
public class HelloServlet2 implements Servlet {

	public void init(ServletConfig var1) {
		System.out.println("HelloServlet#init");
	}

    public void service(ServletRequest request, ServletResponse response) throws ServletException, java.io.IOException {
    	System.out.println("HelloServlet#service");

        String name  = request.getParameter("name");

        String greeting = "Hi, " + name;

        request.setAttribute("res", greeting);

        request.getRequestDispatcher("hello/hello-result.jsp").forward(request, response);
    }    

    public void destroy(){
    	System.out.println("HelloServlet#destroy");
    }

    public String getServletInfo() { 
	    return "";
    }

    public ServletConfig getServletConfig() { 
	    return null;
    }
}
