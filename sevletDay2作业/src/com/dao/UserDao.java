package com.dao;

import java.util.List;

import com.domain.User;

public interface UserDao {
	void add(User user);
	void remove(Integer id);
	void updata(User user);
	User select(Integer id);
	List<User> selectAll();
	User login(String name, String password);
}
