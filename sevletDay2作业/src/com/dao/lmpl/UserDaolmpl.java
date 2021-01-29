package com.dao.lmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.domain.User;
import com.util.JDBCUtil;

public class UserDaolmpl implements UserDao {

	@Override
	public void add(User user) {
		PreparedStatement ps=null;
		try {
			String sql="insert into tb_user(name,password,sex)values(?,?,?)";
			String[] parameter = {user.getName(),user.getPassword(),user.getSex()};
			ps=JDBCUtil.getPS(sql, parameter);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer id) {
		
	}

	@Override
	public void updata(User user) {
		Connection con =null;
		PreparedStatement ps=null;
		try {
			String sql="update tb_user set name=?,password=?,sex=? where id=?";
			con=JDBCUtil.getcon();
			ps = con.prepareStatement(sql);
			ps.setObject(1,user.getName());
			ps.setObject(2,user.getPassword());
			ps.setObject(3,user.getSex());
			ps.setObject(4, user.getId().toString());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public User select(Integer id) {
		String sql="select * from tb_user where id=?";
		String[] peremiter= {id.toString()}; 
		ResultSet re=null;
		try {
			re=JDBCUtil.getResultSet(sql, peremiter);
			while(re.next()){
				User user = new User();
				user.setId(re.getInt("id"));
				user.setName(re.getString("name"));
				user.setPassword(re.getString("password"));
				user.setSex(re.getString("sex"));
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(JDBCUtil.getcon(),JDBCUtil.getSt(),re);
		}
		return null;
	}

	@Override
	public List<User> selectAll() {
		
		String sql="select * from tb_user"; 
		ResultSet re=null;
		List<User> users= new ArrayList<User>();
		try {
			re=JDBCUtil.getResultSet(sql, null);
			while(re.next()){
				User user = new User();
				user.setId(re.getInt("id"));
				user.setName(re.getString("name"));
				user.setPassword(re.getString("password"));
				user.setSex(re.getString("sex"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(JDBCUtil.getcon(),JDBCUtil.getSt(),JDBCUtil.getRe());
		}
		return users;
	}

	@Override
	public User login(String name, String password) {
		String sql="select * from tb_user where name=?and password=?";
		String[] peremiter= {name,password}; 
		ResultSet re=null;
		try {
			re=JDBCUtil.getResultSet(sql, peremiter);
			while(re.next()){
				User user = new User();
				user.setId(re.getInt("id"));
				user.setName(re.getString("name"));
				user.setPassword(re.getString("password"));
				user.setSex(re.getString("sex"));
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(JDBCUtil.getcon(),JDBCUtil.getSt(),re);
		}
		return null;
	}

}
