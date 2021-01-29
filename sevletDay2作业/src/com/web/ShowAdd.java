package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.service.UserService;
import com.service.lmpl.UserServiceDao;

/**
 * Servlet implementation class ShowAdd
 */
public class ShowAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		user.setSex(request.getParameter("sex"));
		UserService userdao = new UserServiceDao();
		userdao.add(user);
		List<User> users = userdao.selectAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher("userTable").forward(request, response);
	}
}
