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

		int cpage = 1; // 当前页
		int count = 5; // 每页显示的条数

		// 获取用户传的页面参数
		String cp = request.getParameter("cp");

		// 接收关键字搜索
		String keyword = request.getParameter("keywords");

		if (cp != null) {
			// 转成整数
			cpage = Integer.parseInt(cp);
		}
		// 获取总页数
		int arr[] = USERDao.totalPage(count, keyword);

		// 调用查询用户的方法 获取所有的用户记录
		ArrayList<USER> list = USERDao.selectAll(cpage, count, keyword);
		// 用户列表放到请求对象域里
		request.setAttribute("userlist", list);
		// 总条数，总页数放到请求对象域里
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);

		if (keyword != null) {
			request.setAttribute("searchparam", "&keywords=" + keyword);
		}

		// 把数据带入用户列表
		request.getRequestDispatcher("admin_user.jsp").forward(request,
				response);
	}

}
