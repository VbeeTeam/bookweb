package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.service.USERDao;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/admin/admin_douserdel")
public class DoUserDel extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的字符集
		request.setCharacterEncoding("UTF-8");
		// 设置响应字符集
		response.setContentType("text/html;charset=utf-8");

		// 获取传递的字段
		String id = request.getParameter("id");

		// 删除
		int count = USERDao.del(id);

		// 成功或失败 true
		if (count > 0) {
			// 重定向到用户列表
			response.sendRedirect("/myshop/admin/admin_douserselect?cp="
					+ request.getParameter("cpage"));
		} else {
			// 输出流
			// 获取到的打印流
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('用户删除失败')");
			out.write("location.href='admin/admin_user.jsp'");
			out.write("</script>");
		}
	}

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
		String ids[] = request.getParameterValues("id[]");

		for (int i = 0; i < ids.length; i++) {
			// 删除
			USERDao.del(ids[i]);
		}

		response.sendRedirect("/myshop/admin/admin_douserselect");

	}

}
