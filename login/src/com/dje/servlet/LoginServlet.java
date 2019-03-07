package com.dje.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dje.pojo.Users;
import com.dje.service.UsersService;
import com.dje.service.impl.UsersServiceImpl;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private UsersService usersService;
	@Override
	public void init() throws ServletException {
		WebApplicationContext wac=WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		usersService=wac.getBean("userService",UsersServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {						
		Users users=new Users();
		users.setUsername(req.getParameter("username"));
		users.setPassword(req.getParameter("password"));
		Users user=usersService.login(users);
		if(user!=null) {
			resp.sendRedirect("main.jsp");
		}else {
			resp.sendRedirect("index.jsp");
		}
	}
}
