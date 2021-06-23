package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.USER;

public class USERDao {
	// 1.用户的添加方法
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

	// 3.获取列表总数和总页数 count：条数
	public static int[] totalPage(int count, String keyword) {
		// 0总记录数 1页数
		int arr[] = { 0, 1 };
		// 获取数据库连接对象
		Connection conn = Basedao.getconn();
		// 声明语句对象
		PreparedStatement ps = null;
		// 设置结果集
		ResultSet rs = null;

		try {

			if (keyword != null) {
				String sql = "select count(*) from USER where USER_NAME like ?";
				// 准备sql语句
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + keyword + "%");
			} else {
				String sql = "select count(*) from USER";
				// 准备sql语句
				ps = conn.prepareStatement(sql);
			}

			// 执行sql语句
			rs = ps.executeQuery();

			while (rs.next()) {
				// 结果集中取到总记录数
				arr[0] = rs.getInt(1);
				// 计算页数
				if (arr[0] % count == 0) {
					arr[1] = arr[0] / count;
				} else {// 总页数加1
					arr[1] = arr[0] / count + 1;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return arr;
	}

	// 2.用户查询的方法
	public static ArrayList<USER> selectAll(int cpage, int count, String keyword) {
		// 创建一个列表对象
		ArrayList<USER> list = new ArrayList<USER>();

		// 声明结果集
		ResultSet rs = null;
		// 获取连接对象
		Connection conn = Basedao.getconn();
		// 准备SQL语句
		PreparedStatement ps = null;

		try {
			// String sql = "select * from USER order by USER_BIRTHDAY";
			if (keyword != null) {
				// 模糊搜索
				String sql = "select * from USER where USER_NAME like ? order by USER_BIRTHDAY desc limit ?, ?";
				// 连接对象里准备sql语句
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + keyword + "%");
				// 设置语句 1=从第几条开始取 2=取的条数范围
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				String sql = "select * from USER order by USER_BIRTHDAY desc limit ?, ?";
				// 连接对象里准备sql语句
				ps = conn.prepareStatement(sql);
				// 设置语句 1=从第几条开始取 2=取的条数范围
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);
			}

			// 执行查询结果给结果集
			rs = ps.executeQuery();

			while (rs.next()) {
				USER u = new USER(rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("USER_BIRTHDAY"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"), rs.getInt("USER_STATUS"),
						rs.getString("USER_MEMO"));
				// 数据添加到列表
				list.add(u);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 最后关闭结果集、sql、连接
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
}
