package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.BOOK;

public class BOOKDao {
	// 1.图书的添加方法
	public static int insert(BOOK b) {
		String sql = "insert into BOOK values(?, ?, ?, ?)";
		// 获取参数的方法
		Object[] params = { b.getBOOK_ID(), b.getBOOK_NAME(),
				b.getBOOK_PRICE(), b.getBOOK_FILENAME() };
		// 返回通用语句的sql方法
		return Basedao.exectuIUD(sql, params);
	}

	// 查询
	// 2.用户查询的方法
	public static ArrayList<BOOK> selectAll() {
		// 创建一个列表对象
		ArrayList<BOOK> list = new ArrayList<BOOK>();

		// 声明结果集
		ResultSet rs = null;
		// 获取连接对象
		Connection conn = Basedao.getconn();
		// 准备SQL语句
		PreparedStatement ps = null;

		try {

			String sql = "select * from BOOK";
			// 连接对象里准备sql语句
			ps = conn.prepareStatement(sql);

			// 执行查询结果给结果集
			rs = ps.executeQuery();

			while (rs.next()) {
				BOOK b = new BOOK(rs.getInt("BOOK_ID"),
						rs.getString("BOOK_NAME"), rs.getInt("BOOK_PRICE"),
						rs.getString("BOOK_FILENAME"));
				// 数据添加到列表
				list.add(b);
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
