package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;

/**
 * Servlet implementation class UserTable
 */
public class UserTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		 List<User> users = (List<User>) request.getAttribute("users");
		 out.println("<table border='1'>");
		 out.println("<tr><th>id</th><th>姓名</th><th>密码</th><th>性别</th><th>操作</th></tr>");
		 out.println("<a href='addUser'>添加用户<a/>");
		 for (User u : users) {
			out.println("<tr>");
			out.println("<td>" + u.getId()+"</td>");
			out.println("<td>" + u.getName()+"</td>");
			out.println("<td>" + u.getPassword()+"</td>");
			out.println("<td>" + u.getSex()+"</td>");
			out.println("<td><a href='userUpdata?id="+u.getId()+"'>修改</a>|<a href='#'>删除</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

}
