package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.USER;
import com.lmonkey.service.USERDao;

/**
 * Servlet implementation class DoUserAdd
 */
// 请求地址
@WebServlet("/admin/admin_douseradd")
public class DoUserAdd extends HttpServlet {

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
		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");

		// 创建用户实体
		USER u = new USER(userName, name, pwd, sex, year, email, mobile,
				address, 1, null);

		// 加入到数据库的用户表中
		// ！！！最后一步写调用USERDao.insert方法
		int count = USERDao.insert(u);

		// 成功或失败 true
		if (count > 0) {
			// 重定向到用户列表
			response.sendRedirect("/myshop/admin/admin_douserselect");
		} else {
			// 输出流
			// 获取到的打印流
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('用户添加失败')");
			out.write("location.href='admin/admin_useradd.jsp'");
			out.write("</script>");
		}

	}
}
