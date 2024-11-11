package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.test.common.DbUtils;
import com.test.entity.Provider;
import com.test.entity.User;

/**
 * 实现对User_message表进行操作的方法
 * 
 * @author 超市账单
 *
 */
public class ProviderDao {
	public int delete(String providerId) throws ClassNotFoundException, SQLException {
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
			String sql = "delete from provider where provider_id=?";
			// 创建语句准备对象，并设置准备语句对象将要执行的insert语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句对象中的问号
			ps.setString(1,providerId);
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
	public int insert(Provider provider) throws ClassNotFoundException, SQLException {
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
			String sql = "insert into provider(provider_no,provider_name,provider_describe,provider_contacts,provider_tel,provider_loc) values(?,?,?,?,?,?)";
			// 创建语句准备对象，并设置准备语句对象将要执行的insert语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句对象中的问号
			ps.setInt(1, provider.getProviderNo());
			ps.setString(2, provider.getProviderName());
			ps.setString(3, provider.getProviderDescribe());
			ps.setString(4, provider.getProviderContacts());
			ps.setString(5, provider.getProviderTel());
			ps.setString(6, provider.getProviderLoc());
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
	public int update(Provider provider) throws ClassNotFoundException, SQLException {
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
			String sql = "update provider set provider_no=?,provider_name=?,provider_describe=?,provider_contacts=?,provider_tel=?,provider_loc=? where provider_id=?";
			// 创建语句准备对象，并设置准备语句对象将要执行的insert语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句对象中的问号
			ps.setInt(1, provider.getProviderNo());
			ps.setString(2, provider.getProviderName());
			ps.setString(3, provider.getProviderDescribe());
			ps.setString(4, provider.getProviderContacts());
			ps.setString(5, provider.getProviderTel());
			ps.setString(6, provider.getProviderLoc());
			ps.setInt(7, provider.getProviderId());
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
	public List<Provider> selectProvider(String providerName,String providerDescribe) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 获得数据库连接对象
			conn = DbUtils.getConnection();
			// 创建select语句，查询user表中所有数据
			StringBuilder sql = new StringBuilder(
					"select provider_id,provider_no,provider_name,provider_describe,provider_contacts,provider_tel,provider_loc from provider where 1=1");
			// 根据方法的形参传递数据，拼接select语句
			
			
			
			if (providerName != null && !providerName.trim().equals("")) {
				sql.append(" and provider_name like ?");
			}
			
			if (providerDescribe != null && !providerDescribe.trim().equals("")) {
				sql.append(" and provider_describe like ?");
			}
			// 创建准备语句对象，并设置准备语句对象将要执行的语句
			ps = conn.prepareStatement(sql.toString());

			if (providerName != null && !providerName.trim().equals("")) {
				ps.setString(1, "%" + providerName + "%");
				if (providerDescribe != null && !providerDescribe.trim().equals("")) {
					ps.setString(2, "%" + providerDescribe + "%");
				}
			}
			else {
				if (providerDescribe != null && !providerDescribe.trim().equals("")) {
					ps.setString(1, "%" + providerDescribe + "%");
				}
			}
			
			
			// 使用准备语句对象执行select语句，并将查询的结果存入到结果集中
			rs = ps.executeQuery();
			// 创建list集合，用于保存结果集中所有的数据
			List<Provider> list = new ArrayList<>();
			// 声明实体变量，用于保存结果集中的一行数据
			Provider provider = null;
			// 使用循环将结果集中的数据封装对list集合中
			while (rs.next()) {
				provider = new Provider();
				provider.setProviderId(rs.getInt("provider_id"));
				provider.setProviderNo(rs.getInt("provider_no"));
				provider.setProviderName(rs.getString("provider_name"));
				provider.setProviderDescribe(rs.getString("provider_describe"));
				provider.setProviderContacts(rs.getString("provider_contacts"));
				provider.setProviderTel(rs.getString("provider_tel"));
				provider.setProviderLoc(rs.getString("provider_loc"));
				list.add(provider);
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
	public Provider selectContProvider(String providerId) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 获得数据库连接对象
			conn = DbUtils.getConnection();
			// 创建select语句，查询user表中所有数据
			StringBuilder sql = new StringBuilder(
					"select provider_id,provider_no,provider_name,provider_describe,provider_contacts,provider_tel,provider_loc from provider where provider_id=?");
			// 根据方法的形参传递数据，拼接select语句
			
			// 创建准备语句对象，并设置准备语句对象将要执行的语句
			ps = conn.prepareStatement(sql.toString());

			if (providerId != null && !providerId.trim().equals("")) {
				ps.setString(1,providerId);
			}

			// 使用准备语句对象执行select语句，并将查询的结果存入到结果集中
			rs = ps.executeQuery();
			// 创建list集合，用于保存结果集中所有的数据
			
			// 声明实体变量，用于保存结果集中的一行数据
			Provider provider = new Provider();
			// 使用循环将结果集中的数据封装对list集合中
			while (rs.next()) {
				provider.setProviderId(rs.getInt("provider_id"));
				provider.setProviderNo(rs.getInt("provider_no"));
				provider.setProviderName(rs.getString("provider_name"));
				provider.setProviderDescribe(rs.getString("provider_describe"));
				provider.setProviderContacts(rs.getString("provider_contacts"));
				provider.setProviderTel(rs.getString("provider_tel"));
				provider.setProviderLoc(rs.getString("provider_loc"));
			}
			// 返回list集合
			return provider;
		} finally {
			// 关闭数据库连接对象
			DbUtils.close(rs, ps, conn);
		}
	}
}
