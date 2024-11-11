package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.UserDao;
import com.test.entity.User;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置字符集
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 获得用户在浏览器中输入的编号和密码
		String tempUser = req.getParameter("userUser");
		String userPassWord = req.getParameter("userpwd");
		// 验证编号不能为空，1-5的整数
		if (!tempUser.matches("^[0-9]{1,16}$")) {
			// 方法1：System.out.println("密码不能为空，且只能是1-5位的整数！！");
			// 方法2：从当前servlet跳转到login.jsp页面，将错误信息传递到login.jsp页面
			req.setAttribute("message", "<script>alert('账号不为空！！')</script>");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		// 验证密码不能为空
		if (userPassWord == null || userPassWord.trim().equals("")) {
			req.setAttribute("userUser", Integer.parseInt(tempUser));
			req.setAttribute("message", "<script>alert('密码不能为空')</script>");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		try {
			// 验证用户是否登录成功
			//throw new Exception();
			//调用usermessagedao的login方法验证用户是否成功
			HttpSession session2 = req.getSession(true);
			UserDao dao = new UserDao();
			User user = dao.login(Integer.parseInt(tempUser), userPassWord);
			if (user!=null) {
				//登录成功
				session2.setAttribute("loginUserName", user.getUserName());
				session2.setAttribute("loginUserRole", user.getUserRole());
				resp.sendRedirect(resp.encodeRedirectURL("pages/admin_index.jsp"));
			} else {
				//登录失败，从当前servlet跳转到login.jsp页面，并向login.jsp页面传递错误信息
				req.setAttribute("message", "<script>alert('程序异常')</script>");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("login.jsp");
		}
	}
}
