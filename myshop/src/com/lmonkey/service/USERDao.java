package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.USER;

public class USERDao {
	// 用户的添加方法
	public static int insert(USER u) {
		String sql = "insert into USER values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";
		// 获取参数的方法
		Object[] params = { u.getUSER_ID(), u.getUSER_NAME(),
				u.getUSER_PASSWORD(), u.getUSER_SEX(), u.getUSER_BIRTHDAY(),
				u.getUSER_EMAIL(), u.getUSER_MOBILE(), u.getUSER_ADDRESS(),
				u.getUSER_STATUS(), u.getUSER_MEMO() };
		// 返回通用语句的sql方法
		return Basedao.exectuIUD(sql, params);
	}

	// 用户查询的方法
	public static ArrayList<USER> selectAll() {
		// 创建一个列表对象
		ArrayList<USER> list = new ArrayList<USER>();

		// 声明结果集
		ResultSet rsResultSet = null;
		// 获取连接对象
		Connection conn = Basedao.getconn();
		// 准备SQL语句
		PreparedStatement ps = null;

		try {
			String sql = "select * from USER order by USER_BIRTHDAY";
			conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
