package com.lmonkey.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.USER;
import com.lmonkey.service.USERDao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/admin/admin_douserselect")
public class DoUserSelect extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 调用查询用户的方法 获取所有的用户记录
		ArrayList<USER> list = USERDao.selectAll();
		// 放到请求对象域里
		request.setAttribute("userlist", list);
		// 把数据带入用户列表
		request.getRequestDispatcher("admin_user.jsp").forward(request,
				response);
	}

}
