package com.home.diana.controller.hello;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/hello")
public class HelloServlet implements Servlet {

	public void init(ServletConfig var1) {
		System.out.println("HelloServlet#init");
	}



    public void service(ServletRequest request, ServletResponse response) throws java.io.IOException {
    	System.out.println("HelloServlet#service");

        String name  = request.getParameter("name");

        HttpServletResponse httpRes = (HttpServletResponse)response;
        httpRes.getWriter()
        .append("<html><body>")
            .append("<h2>Hi, ")
            .append(name)
            .append("!</h2>")
            .append("<a href='hello/hello-index-old.html'>Back</a>")
            .append("</body></html>");

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
