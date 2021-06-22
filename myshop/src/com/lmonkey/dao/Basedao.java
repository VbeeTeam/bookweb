package com.lmonkey.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//链接数据库的类
public class Basedao {
	// 静态对象
	static {
		// 加载mysql8驱动
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
		// 使用jdbc连接驱动地址
		try {
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/shop3?useSSL=false&serverTimezone=UTC",
							"root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 处理通用sql语句方法
	public static int exectuIUD(String sql, Object[] params) {
		// 返回的行数
		int count = 0;
		// 获取连接数据库的方法
		Connection conn = Basedao.getconn();
		// 准备sql语句执行 import导包
		PreparedStatement ps = null;

		try {
			// 准备执行的sql语句
			// inset into user(,,,) value(?, ?, ?)
			ps = conn.prepareStatement(sql);

			for (int i = 0; i < params.length; i++) {
				// 设置参数字段
				ps.setObject(i + 1, params[i]);
			}
			// 执行语句返回行数
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 最后写！！！关闭数据库的方法
			Basedao.closeall(null, ps, conn);
		}
		return count;
	}

	// 关闭数据库的返回方法 结果集，预处理对象，连接对象
	public static void closeall(ResultSet rs, PreparedStatement ps,
			Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
