package com.test.service;

/**
 * 用户模块的业务逻辑层
 * @author 超市账单
 *
 */

import java.sql.SQLException;
import java.util.List;



import com.test.dao.BillDao;
import com.test.dao.UserDao;
import com.test.entity.Bill;
import com.test.entity.Provider;
import com.test.entity.User;

public class BillService {

	// 创建持久化层对象
	private BillDao Billdao = new BillDao();

	/**
	 * 查询满足条件的用户信息
	 * 
	 * @param userMessage 查询条件（用户姓名，联系电话）
	 * @return 返回一个java.util.List的实例
	 * @throws ClassNotFoundException 数据库驱动加载失败
	 * @throws SQLException           数据库操作异常
	 */
	
	public List<Bill> selectBill(String billProname,String billPayment) throws ClassNotFoundException, SQLException {
		return this.Billdao.selectBill(billProname,billPayment);
	}

	public Bill selectContBill(String BillId) throws ClassNotFoundException, SQLException {
		return this.Billdao.selectContBill(BillId);
	}
	
	public int deleteBill(String BillId) throws ClassNotFoundException, SQLException {
		return this.Billdao.delete(BillId);
	}
	
	public int updateContBill(Bill bill) throws ClassNotFoundException, SQLException {
		return this.Billdao.updateContBill(bill);
	}
	
	public int insert(Bill bill) throws ClassNotFoundException, SQLException {
		return this.Billdao.insert(bill);
	}
}
