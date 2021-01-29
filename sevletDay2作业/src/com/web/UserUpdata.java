package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.service.UserService;
import com.service.lmpl.UserServiceDao;

/**
 * Servlet implementation class UserUpdata
 */
public class UserUpdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		if(!"".equals(sid)&&sid!=null) {
			UserService udao = new UserServiceDao();
			User user = udao.select(Integer.parseInt(sid));
			if(user!=null) {
				
				out.println("<form action='showUpdata' method='post'>");
				out.println("<input type='hidden' name='id' value='" + user.getId() + "'><br/>");
				out.println("新用户名<input type='text' name='name' value='"+user.getName()+"'><br/>");
				out.println("新密码<input type='password' name='password' value='"+user.getPassword()+"'><br/>");
				String checked="";
				String checked2="";
				if(user.getSex().equals("男")) {
					checked="checked";
				}else {
					checked2="checked";
				}
				out.println("请选择性别<input type='radio' name='sex' value='男' "+checked+">男");
				out.println("<input type='radio' name='sex' value='女'"+checked2+">女");
				out.println("<button>提交</button>");
				
				out.println("</form>");
			}
			
		}
	}

}
