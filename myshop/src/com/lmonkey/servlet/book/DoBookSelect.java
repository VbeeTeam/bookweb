package com.lmonkey.servlet.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.BOOK;
import com.lmonkey.service.BOOKDao;

/**
 * Servlet implementation class DoBookSelect
 */
@WebServlet("/admin/admin_dobookselect")
public class DoBookSelect extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 调用查询用户的方法 获取所有的用户记录
		ArrayList<BOOK> list = BOOKDao.selectAll();
		// 用户列表放到请求对象域里
		request.setAttribute("booklist", list);
		// 把数据带入用户列表
		request.getRequestDispatcher("admin_book.jsp").forward(request,
				response);
	}

}
