package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<form action='showAdd' method='post'>");
		out.println("<label>用户名</label><input type='text' name='name'>");
		out.println("<label>用户密码</label><input type='password' name='password'>");
		out.println("<label>男</label><input type='radio' name='sex' value='男' checked> ");
		out.println("<label>女</label><input type='radio' name='sex' value='女' > ");
		out.println("<button>注册</button>");
		out.println("</form>");
	}

}
