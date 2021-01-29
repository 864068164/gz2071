package com.service.lmpl;

import java.util.List;

import com.dao.UserDao;
import com.dao.lmpl.UserDaolmpl;
import com.domain.User;
import com.service.UserService;

public class UserServiceDao implements UserService {
	private static UserDao udao = new UserDaolmpl();
	@Override
	public void add(User user) {
		udao.add(user);
	}

	@Override
	public void remove(Integer id) {


	}

	@Override
	public void updata(User user) {
		udao.updata(user);
	}

	@Override
	public User select(Integer id) {
		User user = udao.select(id);
		return user;
	}

	@Override
	public List<User> selectAll() {
		List<User> userAll = udao.selectAll();
		return userAll;
	}

	@Override
	public User login(String name, String password) {
		User login = udao.login(name, password);
		return login;
	}
	public void test () {}
}
