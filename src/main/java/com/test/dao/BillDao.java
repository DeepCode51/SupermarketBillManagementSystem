package com.test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.test.common.DbUtils;
import com.test.entity.Bill;
import com.test.entity.Provider;
import com.test.entity.User;

/**
 * 实现对User_message表进行操作的方法
 * 
 * @author 超市账单
 *
 */
public class BillDao {
	public int delete(String BillId) throws ClassNotFoundException, SQLException {
		// 声明连接对象
		Connection conn = null;
		// 声明语句对象
		PreparedStatement ps = null;
		// 声明结果集
		ResultSet rs = null;
		// 获得数据库连接对象
		try {
			conn = DbUtils.getConnection();
			// 创建insert语句，向表中添加新的数据
			String sql = "delete from bill where Bill_id=?";
			// 创建语句准备对象，并设置准备语句对象将要执行的insert语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句对象中的问号
			ps.setString(1,BillId);
			// 使用准备语句对象执行insert语句，并获得insert语句执行影响表中的数据行数
			int i = ps.executeUpdate();
			// 如果添加成功，提交事务
			if (i > 0) {
				conn.commit();
				return i;
			} else {
				// 如果添加失败，回退事务
				conn.rollback();
			}
		} finally {
			// 关闭数据库相关对象
			DbUtils.close(rs, ps, conn);
		}
		return 0;
	}
	/**
	 * 向表中添加新的用户信息。
	 * 
	 * @param userMessage 新的用户信息（用户名，密码，联系电话，邮箱）
	 * @return 添加成功返回大于0的整数，否则返回0
	 * @throws ClassNotFoundException 数据库驱动加载失败异常
	 * @throws SQLException           数据库操作异常
	 */
	public int insert(Bill bill) throws ClassNotFoundException, SQLException {
		// 声明连接对象
		Connection conn = null;
		// 声明语句对象
		PreparedStatement ps = null;
		// 声明结果集
		ResultSet rs = null;
		// 获得数据库连接对象
		try {
			conn = DbUtils.getConnection();
			// 创建insert语句，向表中添加新的数据
			String sql = "insert into bill(bill_no,bill_proname,bill_pronum,bill_price,bill_payment,bill_prodescribe,provider_id) values(?,?,?,?,?,?,?)";
			// 创建语句准备对象，并设置准备语句对象将要执行的insert语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句对象中的问号
			ps.setInt(1, bill.getBillNo());
			ps.setString(2, bill.getBillProname());
			ps.setInt(3, bill.getBillPronum());
			ps.setDouble(4, bill.getBillPrice());
			ps.setBoolean(5, bill.getBillPayment());
			ps.setString(6, bill.getBillProdescribe());
			ps.setString(7, bill.getProviderId());
			// 使用准备语句对象执行insert语句，并获得insert语句执行影响表中的数据行数
			int i = ps.executeUpdate();
			// 如果添加成功，提交事务
			if (i > 0) {
				conn.commit();
				return i;
			} else {
				// 如果添加失败，回退事务
				conn.rollback();
			}
		} finally {
			// 关闭数据库相关对象
			DbUtils.close(rs, ps, conn);
		}

		return 0;
	}

	/**
	 * 查询user_message表中满足条件的数据
	 * 
	 * @param userMessage 查询的条件（用户姓名，联系电话）
	 * @return 返回java.util.List类型的实例
	 * @throws ClassNotFoundException 数据库驱动加载失败
	 * @throws SQLException           数据库操作异常
	 */
	public List<Bill> selectBill(String billProname,String billPayment) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 获得数据库连接对象
			conn = DbUtils.getConnection();
			// 创建select语句，查询user表中所有数据
			StringBuilder sql = new StringBuilder(
					"select bill_id,bill_no,bill_proname,bill_pronum,bill_price,bill_payment,bill_prodescribe,bill_date,bill.provider_id,provider_name from bill,provider where bill.provider_id=provider.provider_id");
			// 根据方法的形参传递数据，拼接select语句

			if (billProname != null && !billProname.trim().equals("")) {
				sql.append(" and bill_proname like ?");
			}
			
			if (billPayment != null && !billPayment.trim().equals("")) {
				sql.append(" and bill_payment=? ");
			}
			
			// 创建准备语句对象，并设置准备语句对象将要执行的语句
			ps = conn.prepareStatement(sql.toString());
		    if(billPayment != null && !billPayment.trim().equals("")) {
		    	if(Integer.parseInt(billPayment)<=0) {
					billPayment="0";
				}
				else {
					billPayment="1";
				}
		    }
			
			if (billProname != null && !billProname.trim().equals("")) {
				ps.setString(1, "%" + billProname + "%");
				if (billPayment != null && !billPayment.trim().equals("")) {
					ps.setString(2, billPayment);
				}
			}
			else {
				if (billPayment != null && !billPayment.trim().equals("")) {
					ps.setString(1,billPayment);
				}
			}
			
			
			// 使用准备语句对象执行select语句，并将查询的结果存入到结果集中
			rs = ps.executeQuery();
			// 创建list集合，用于保存结果集中所有的数据
			List<Bill> list = new ArrayList<>();
			// 声明实体变量，用于保存结果集中的一行数据
			Bill bill = null;
			// 使用循环将结果集中的数据封装对list集合中
			while (rs.next()) {
				bill = new Bill();
				bill.setBillId(rs.getInt("bill_id"));
				bill.setBillNo(rs.getInt("bill_no"));
				bill.setBillProname(rs.getString("bill_proname"));
				bill.setBillPronum(rs.getInt("bill_pronum"));
				bill.setBillPrice(rs.getDouble("bill_price"));
				bill.setBillPayment(rs.getBoolean("bill_payment"));
				bill.setBillProdescribe(rs.getString("bill_prodescribe"));
				bill.setBillDate(rs.getDate("bill_date"));
				bill.setProviderId(rs.getString("provider_id"));
				bill.setProviderName(rs.getString("provider_name"));
				list.add(bill);
			}
			// 返回list集合
			return list;
		} finally {
			// 关闭数据库连接对象
			DbUtils.close(rs, ps, conn);
		}
	}
	/**
	 * 查询user_message表中满足条件的数据
	 * 
	 * @param userMessage 查询的条件（用户姓名，联系电话）
	 * @return 返回java.util.List类型的实例
	 * @throws ClassNotFoundException 数据库驱动加载失败
	 * @throws SQLException           数据库操作异常
	 */
	public Bill selectContBill(String BillId) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 获得数据库连接对象
			conn = DbUtils.getConnection();
			// 创建select语句，查询user表中所有数据
			StringBuilder sql = new StringBuilder(
					"select bill_id,bill_no,bill_proname,bill_pronum,bill_price,bill_payment,bill_prodescribe,bill_date,provider_id from bill where Bill_id=?");

			// 创建准备语句对象，并设置准备语句对象将要执行的语句
			ps = conn.prepareStatement(sql.toString());

			if (BillId != null && !BillId.trim().equals("")) {
				ps.setString(1,  BillId );			
			}

			// 使用准备语句对象执行select语句，并将查询的结果存入到结果集中
			rs = ps.executeQuery();
			// 创建list集合，用于保存结果集中所有的数据
			List<Bill> list = new ArrayList<>();
			// 声明实体变量，用于保存结果集中的一行数据
			Bill bill = new Bill();
			// 使用循环将结果集中的数据封装对list集合中
			
			while (rs.next()) {
				bill.setBillId(rs.getInt("bill_id"));
				bill.setBillNo(rs.getInt("bill_no"));
				bill.setBillProname(rs.getString("bill_proname"));
				bill.setBillPronum(rs.getInt("bill_pronum"));
				bill.setBillPrice(rs.getDouble("bill_price"));
				bill.setBillPayment(rs.getBoolean("bill_payment"));
				bill.setBillProdescribe(rs.getString("bill_prodescribe"));
				bill.setBillDate(rs.getDate("bill_date"));
				bill.setProviderId(rs.getString("provider_id"));
			}
			// 返回list集合
			return bill;
		} finally {
			// 关闭数据库连接对象
			DbUtils.close(rs, ps, conn);
		}
	}
	/**
	 * 查询user_message表中满足条件的数据
	 * 
	 * @param userMessage 查询的条件（用户姓名，联系电话）
	 * @return 返回java.util.List类型的实例
	 * @throws ClassNotFoundException 数据库驱动加载失败
	 * @throws SQLException           数据库操作异常
	 */
	public int updateContBill(Bill bill) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try {
			// 获得数据库连接对象
			conn = DbUtils.getConnection();
			// 创建select语句，查询user表中所有数据
			StringBuilder sql = new StringBuilder(
					"update bill set bill_no=?,bill_proname=?,bill_pronum=?,bill_price=?,bill_payment=?,bill_prodescribe=?,provider_id=? where bill_id = ?");
			
			// 创建准备语句对象，并设置准备语句对象将要执行的语句
			ps = conn.prepareStatement(sql.toString());

			if (bill.getBillId() != null) {
				ps.setInt(1, bill.getBillNo());		
				ps.setString(2, bill.getBillProname());		
				ps.setInt(3, bill.getBillPronum());		
				ps.setDouble(4, bill.getBillPrice());		
				ps.setBoolean(5, bill.getBillPayment());		
				ps.setString(6, bill.getBillProdescribe());		
				ps.setString(7, bill.getProviderId());		
				ps.setInt(8, bill.getBillId());			
			}
			else {
				return 0;
			}
			
			// 使用准备语句对象执行select语句，并将查询的结果存入到结果集中
			rs = ps.executeUpdate();
			// 创建list集合，用于保存结果集中所有的数据

			return rs;
		} finally {
			// 关闭数据库连接对象
			DbUtils.close(null, ps, conn);
		}
	}
}
