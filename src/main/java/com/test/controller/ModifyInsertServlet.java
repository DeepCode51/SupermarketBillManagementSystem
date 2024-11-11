package com.test.controller;

import java.io.IOException;
import java.util.List;

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
import com.test.service.BillService;
import com.test.service.ProviderService;
import com.test.service.UserService;

public class ModifyInsertServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	
		try {
			ProviderService Pservice = new ProviderService();
			BillService Bservice = new BillService();
			Bill bill = new Bill();
			
			String billId = req.getParameter("billId");
			if(billId != null) {
				bill = Bservice.selectContBill(billId);
				req.setAttribute("bill", bill);
			}
			List<Provider> list = Pservice.selectProvider(null,null);
			req.setAttribute("providerList", list);
			req.getRequestDispatcher("/pages/modify.jsp").forward(req, resp);
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
		String billId = req.getParameter("billId");
		String billNo = req.getParameter("billNum");
		String billPrice = req.getParameter("money");
		String billPronum = req.getParameter("sum");
		String billProname = req.getParameter("title");
		String billProdescribe = req.getParameter("discription");
		String billPayment = req.getParameter("isPay");
		String providerId = req.getParameter("providerId");
		// 服务器的验证
		// 验证用户姓名，用户密码，确认密码，联系电话，邮箱是否为空
		// 验证用户姓名不为空
		if (billNo == null || billNo.trim().equals("")) {
			req.setAttribute("money", billPrice);
			req.setAttribute("discription", billProdescribe);
			req.setAttribute("isPay", billPayment);
			req.setAttribute("message", "<script>alert('编号不能为空!');</script>");
			req.getRequestDispatcher("/supermarket/pages/modify.jsp").forward(req, resp);
			return;
		}
		
		// 验证用户密码不为空
		if (billPrice == null || billPrice.trim().equals("")) {
			req.setAttribute("billNum", billNo);
			req.setAttribute("discription", billProdescribe);
			req.setAttribute("isPay", billPayment);
			req.setAttribute("message", "<script>alert('金额不能为空!');</script>");
			req.getRequestDispatcher("/supermarket/pages/modify.jsp").forward(req, resp);
			return;
		}
		
		// 将数据封装到user message实体类的对象中
		Bill bill = new Bill();
		if(billId!=null && !"".equals(billId)){
			bill.setBillId(Integer.parseInt(billId));
		}

		bill.setBillNo(Integer.parseInt(billNo));
		bill.setBillPronum(Integer.parseInt(billPronum)); 
		bill.setBillProname(billProname);
		bill.setBillPrice(Double.parseDouble(billPrice));
		bill.setBillProdescribe(billProdescribe);
		if(Integer.parseInt(billPayment)<=0) {
			bill.setBillPayment(false);
		}
		else {
			bill.setBillPayment(true);
		}
		bill.setProviderId(providerId);
		
		try {
			// 调用usermessagedao类中名为inset()方法进行用户注册操作，并获得注册是否成功
			BillDao dao = new BillDao();
			if(billId != null && !"".equals(billId)) {
				int update = dao.updateContBill(bill);
				if (update > 0) {
					HttpSession session=req.getSession(true);
					req.setAttribute("message", "<script>alert('修改成功!');</script>");
					resp.sendRedirect(resp.encodeRedirectURL("/supermarket/selectbill"));
				} else {
					req.setAttribute("message", "<script>alert('修改失败!');</script>");
					req.getRequestDispatcher("/supermarket/pages/modify.jsp").forward(req, resp);
				}
			}
			else {
				int insert = dao.insert(bill);
				if (insert > 0) {
					HttpSession session=req.getSession(true);
					req.setAttribute("message", "<script>alert('添加成功!');</script>");
					resp.sendRedirect(resp.encodeRedirectURL("/supermarket/selectbill"));
				} else {
					req.setAttribute("message", "<script>alert('添加失败!');</script>");
					req.getRequestDispatcher("/supermarket/pages/modify.jsp").forward(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("error.html");
		}
	}
}
