package com.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JDBCUtil {
	private static DataSource rs;
	private static Properties p= new Properties();
	private static Connection con;
	private static PreparedStatement st;
	private static ResultSet re;
	static {
	
		try(InputStream in = JDBCUtil.class.getResourceAsStream("/jdbc.properties")) {
			p.load(in);
			Class.forName(p.getProperty("driverClassName"));
			rs=DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getcon() {
		try {
			con = rs.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	public static void  close(Connection con,PreparedStatement st,ResultSet re) {
			try {
				if(re!=null) {
					re.close();
				}
				if(st!=null) {
					st.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static ResultSet getResultSet(String sql,String[] args){
		try {
			con=getcon();
			st = con.prepareStatement(sql);
			if(args!=null){
				for(int i=0;i<args.length;i++) {
					st.setObject(i+1,args[i]);
				}
			}
			re = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}
	public static PreparedStatement getPS(String sql,String[] args){
		try {
			con=getcon();
			st = con.prepareStatement(sql);
			if(args!=null){
				for(int i=0;i<args.length;i++) {
					st.setObject(i+1,args[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
	public static Connection getCon() {
		return con;
	}
	public static PreparedStatement getSt() {
		return st;
	}
	public static void setCon(Connection con) {
		JDBCUtil.con = con;
	}
	public static void setSt(PreparedStatement st) {
		JDBCUtil.st = st;
	}
	public static ResultSet getRe() {
		return re;
	}
	public static void setRe(ResultSet re) {
		JDBCUtil.re = re;
	}
	
}
