package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.BillDao;
import com.test.dao.ProviderDao;
import com.test.dao.UserDao;
import com.test.entity.Bill;
import com.test.entity.Provider;
import com.test.entity.User;
import com.test.service.ProviderService;
import com.test.service.UserService;

public class ProviderDelServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置字符集
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 获得用户在浏览器中输入的注册信息
		
		String ProviderId = req.getParameter("providerId");
		if(ProviderId==null) {
			return;
		}
		try {
			// 调用usermessagedao类中名为inset()方法进行用户注册操作，并获得注册是否成功
			ProviderDao dao = new ProviderDao();
			if(ProviderId != null) {
				int delete = dao.delete(ProviderId);
				if (delete > 0) {
					HttpSession session=req.getSession(true);
					req.setAttribute("message", "<script>alert('删除成功!');</script>");
					resp.sendRedirect(resp.encodeRedirectURL("/supermarket/selectprovider"));
				} else {
					req.setAttribute("message", "<script>alert('删除失败!');</script>");
					req.getRequestDispatcher("/selectprovider").forward(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("error.html");
		}
	}

}
