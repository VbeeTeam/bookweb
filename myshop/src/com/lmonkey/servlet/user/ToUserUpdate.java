package com.lmonkey.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.USER;
import com.lmonkey.service.USERDao;

/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/admin/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		// 拿到请求的id
		String id = request.getParameter("id");

		// 通过id查数据
		USER u = USERDao.selectById(id);
		// 用户数据放到请求对象域里
		request.setAttribute("user", u);
		request.setAttribute("cpage", request.getParameter("cpage"));
		// 把数据带入修改页
		request.getRequestDispatcher("admin_useredit.jsp").forward(request,
				response);

	}

}
