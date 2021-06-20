package com.lmonkey.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

//链接数据库的类
public class Basedao {

	static {
		// jdbc加载mysql8驱动

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// 输出一个异常
			e.printStackTrace();
		}

	}

	// 连接数据库的方法
	public static Connection getconn() {
		// 创建一个连接对象
		Connection conn = null;
		// 连接驱动地址
		try {
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/shop?useSSL=false&serverTimezone=UTC",
							"root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 通用sql语句方法
	public static int exectuIUD(String sql, Object[] params) {
		int count = 0;
		// 拿到连接数据库的方法
		Connection conn = Basedao.getconn();
		// 准备sql语句
		PreparableStatement ps = null;

	}

	// 关闭数据库的返回方法
	public static void closeall() {

	}

}
