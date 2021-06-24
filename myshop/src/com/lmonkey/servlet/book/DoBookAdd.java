package com.lmonkey.servlet.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.BOOK;
import com.lmonkey.service.BOOKDao;

/**
 * Servlet implementation class DoBookAdd
 */
@WebServlet("/admin/admin_dobookadd")
public class DoBookAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的字符集
		request.setCharacterEncoding("UTF-8");
		// 设置响应字符集
		response.setContentType("text/html;charset=utf-8");

		// 获取传递的字段
		String bookName = request.getParameter("bookName");
		String bookPrice = request.getParameter("bookPrice");
		String bookFileName = request.getParameter("bookFileName");

		int price = Integer.parseInt(bookPrice);

		// 创建图书实体
		BOOK b = new BOOK(0, bookName, price, bookFileName);

		// 加入到数据库的图书表中
		int count = BOOKDao.insert(b);

		// 成功或失败 true
		if (count > 0) {
			// 重定向到列表
			response.sendRedirect("/myshop/admin/admin_dobookselect");
		}
	}

}
