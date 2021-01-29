package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.service.UserService;
import com.service.lmpl.UserServiceDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("当前是Login---------------");
		response.setContentType("text/html;charSet=utf-8");
		PrintWriter out = response.getWriter();
		//获取页面传递的用户名，密码
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("name="+name+",password"+password);
		//2生成userservice对象
		UserService service = new UserServiceDao();
		User login = service.login(name, password);
		if(login!=null) {
			out.println("欢迎("+login.getName()+")登录");
			UserService user = new UserServiceDao();
			List<User> users = user.selectAll();
			request.setAttribute("users",users);
			RequestDispatcher tz = request.getRequestDispatcher("userTable");
			tz.forward(request,response);
		}else {
			out.println("用户名或密码错误");
		}
	}

}
