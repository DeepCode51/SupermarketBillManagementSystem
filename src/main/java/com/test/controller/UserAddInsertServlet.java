package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.BillDao;
import com.test.dao.UserDao;
import com.test.entity.Bill;
import com.test.entity.Provider;
import com.test.entity.User;
import com.test.service.ProviderService;
import com.test.service.UserService;

public class UserAddInsertServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			UserService Uservice = new UserService();
			String userId = req.getParameter("userId");
			User user = new User();
			if(userId != null) {
				user = Uservice.selecContUser(userId);
				req.setAttribute("user", user);
			}
			req.getRequestDispatcher("/pages/userAdd.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置字符集
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 获得用户在浏览器中输入的注册信息
		
		String userId = req.getParameter("userId");
		String userOn = req.getParameter("userOn");
		String userName = req.getParameter("username");
		String userPassword = req.getParameter("password");
		String userPassword1 = req.getParameter("password1");
		String userSex = req.getParameter("sex");
		String userAge = req.getParameter("age");
		String userTel = req.getParameter("mobile");
		String userLoc = req.getParameter("address");
		String userRole = req.getParameter("auth");
		
		
		// 服务器的验证
		// 验证用户姓名，用户密码，确认密码，联系电话，邮箱是否为空
		// 验证用户姓名不为空
		if (userOn == null || userOn.trim().equals("")) {
			req.setAttribute("message", "<script>alert('编号不能为空!');</script>");
			req.getRequestDispatcher("/useradd").forward(req, resp);
			return;
		}
		
		if(userId == null || userId.trim().equals("")) {
			if (userPassword.trim().equals("") != userPassword1.trim().equals("")) {
				req.setAttribute("message", "<script>alert('密码与确认密码需要相同!');</script>");
				req.getRequestDispatcher("/useradd").forward(req, resp);
				return;
			}
			if (userPassword == null || userPassword.trim().equals("")) {
				req.setAttribute("message", "<script>alert('密码不能为空!');</script>");
				req.getRequestDispatcher("/useradd").forward(req, resp);
				return;
			}
			if (userPassword1 == null || userPassword1.trim().equals("")) {
				req.setAttribute("message", "<script>alert('确认密码不能为空!');</script>");
				req.getRequestDispatcher("/supermarket/useradd").forward(req, resp);
				return;
			}
		}
		
		if (userName == null || userName.trim().equals("")) {
			req.setAttribute("message", "<script>alert('名称不能为空!');</script>");
			req.getRequestDispatcher("/useradd").forward(req, resp);
			return;
		}
		
		if (userSex == null || userSex.trim().equals("")) {
			req.setAttribute("message", "<script>alert('性别不能为空!');</script>");
			req.getRequestDispatcher("/useradd").forward(req, resp);
			return;
		}
		if (userAge == null || userAge.trim().equals("")) {
			req.setAttribute("message", "<script>alert('年龄不能为空!');</script>");
			req.getRequestDispatcher("/useradd").forward(req, resp);
			return;
		}
		if (userTel == null || userTel.trim().equals("")) {
			req.setAttribute("message", "<script>alert('电话不能为空!');</script>");
			req.getRequestDispatcher("/useradd").forward(req, resp);
			return;
		}
		if (userRole == null || userRole.trim().equals("")) {
			req.setAttribute("message", "<script>alert('权限不能为空!');</script>");
			req.getRequestDispatcher("/useradd").forward(req, resp);
			return;
		}
		
		// 将数据封装到user message实体类的对象中
		User user = new User();
		if(userId != null && !"".equals(userId)) {
			user.setUserId(Integer.parseInt(userId));
		}
		
		user.setUserOn(Integer.parseInt(userOn));
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		if(userSex == "0") {
			user.setUserSex("女");
		}
		else {
			user.setUserSex("男");
		}
		
		user.setUserAge(Integer.parseInt(userAge));
		user.setUserTel(userTel);
		user.setUserLoc(userLoc);
		user.setUserRole(userRole);
		
		try {
			// 调用usermessagedao类中名为inset()方法进行用户注册操作，并获得注册是否成功
			UserDao dao = new UserDao();
			if(userId != null&& !"".equals(userId)) {
				int update = dao.update(user);
				if (update > 0) {
					HttpSession session=req.getSession(true);
					req.setAttribute("message", "<script>alert('修改成功!');</script>");
					resp.sendRedirect(resp.encodeRedirectURL("/supermarket/selectUser"));
				} else {
					req.setAttribute("message", "<script>alert('修改失败!');</script>");
					req.getRequestDispatcher("/supermarket/useradd").forward(req, resp);
				}
			}
			else {
				int insert = dao.insert(user);
				if (insert > 0) {
					HttpSession session=req.getSession(true);
					req.setAttribute("message", "<script>alert('添加成功!');</script>");
					resp.sendRedirect(resp.encodeRedirectURL("/supermarket/selectUser"));
				} else {
					req.setAttribute("message", "<script>alert('添加失败!');</script>");
					req.getRequestDispatcher("/supermarket/useradd").forward(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("error.html");
		}
	}

}
