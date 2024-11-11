package com.test.controller;

import java.io.IOException;
import java.util.List;

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
import com.test.service.BillService;
import com.test.service.ProviderService;

public class ProviderInsertServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			
			ProviderService Pservice = new ProviderService();
			String providerId = req.getParameter("providerId");
			Provider provider = new Provider();
			if(providerId != null) {
				provider = Pservice.selectContProvider(providerId);
				req.setAttribute("provider", provider);
			}
			req.getRequestDispatcher("/pages/providerAdd.jsp").forward(req, resp);
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
		String providerId = req.getParameter("providerId");
		String providerNo = req.getParameter("proId");
		String providerName = req.getParameter("proName");
		String providerDescribe = req.getParameter("proDesc");
		String providerContacts = req.getParameter("contact");
		String providerYel = req.getParameter("phone");
		String providerLoc = req.getParameter("address");

		
		// 服务器的验证
		// 验证用户姓名，用户密码，确认密码，联系电话，邮箱是否为空
		// 验证用户姓名不为空
		if (providerNo == null || providerNo.trim().equals("")) {
			req.setAttribute("message", "<script>alert('编号不能为空!');</script>");
			req.getRequestDispatcher("/supermarket/pages/modify.jsp").forward(req, resp);
			return;
		}
		
		// 验证用户密码不为空
		if (providerName == null || providerName.trim().equals("")) {
			req.setAttribute("message", "<script>alert('名称不能为空!');</script>");
			req.getRequestDispatcher("/supermarket/pages/modify.jsp").forward(req, resp);
			return;
		}
		
		// 将数据封装到user message实体类的对象中
		Provider provider = new Provider();
		if(providerId != null &&!"".equals(providerId)) {
			provider.setProviderId(Integer.parseInt(providerId));
		}

		provider.setProviderNo(Integer.parseInt(providerNo));
		provider.setProviderName(providerName); // 数量1
		provider.setProviderDescribe(providerDescribe);
		provider.setProviderContacts(providerContacts);
		provider.setProviderTel(providerYel);
		provider.setProviderLoc(providerLoc);
		
		try {
			// 调用usermessagedao类中名为inset()方法进行用户注册操作，并获得注册是否成功
			if(providerId != null &&!"".equals(providerId)) {
				ProviderDao dao = new ProviderDao();
				int update = dao.update(provider);
				if (update > 0) {
					HttpSession session=req.getSession(true);
					req.setAttribute("message", "<script>alert('修改成功!');</script>");
					resp.sendRedirect(resp.encodeRedirectURL("/supermarket/selectprovider"));
				} else {
					req.setAttribute("message", "<script>alert('修改失败!');</script>");
					req.getRequestDispatcher("/supermarket/provideradd").forward(req, resp);
				}
			}else {
				ProviderDao dao = new ProviderDao();
				int insert = dao.insert(provider);
				if (insert > 0) {
					HttpSession session=req.getSession(true);
					req.setAttribute("message", "<script>alert('添加成功!');</script>");
					resp.sendRedirect(resp.encodeRedirectURL("/supermarket/selectprovider"));
				} else {
					req.setAttribute("message", "<script>alert('添加失败!');</script>");
					req.getRequestDispatcher("/supermarket/provideradd").forward(req, resp);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("error.html");
		}
	}

}
