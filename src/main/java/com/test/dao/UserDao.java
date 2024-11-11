package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.test.common.DbUtils;
import com.test.entity.User;

/**
 * 实现对User_message表进行操作的方法
 * 
 * @author 超市账单
 *
 */
public class UserDao {

	/**
	 * 验证用户是否登录成功
	 * 
	 * @param userId       用户编号
	 * @param userPassword 密码
	 * @return 登录成功返回com.test.entity的实例，否则返回null
	 * @throws SQLException           数据库加载异常
	 * @throws ClassNotFoundException 数据库驱动加载失败
	 */
	public User login(Integer userOn, String userPassword) throws SQLException, ClassNotFoundException {
		// 声明连接对象
		Connection conn = null;
		// 声明语句对象
		PreparedStatement ps = null;
		// 声明结果集
		ResultSet rs = null;
		User user = new User();
		try {

			// 获得数据库连接对象
			conn = DbUtils.getConnection();
			// 创建select语句，判断用户登录信息是否正确
			String sql = "select user_id,user_on,user_name,user_password,user_sex,user_age,user_tel,user_loc,user_role from user where user_on = ? and user_password=?";
			// 创建准备语句对象，并设置准备对象将要执行的select语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句中的问号
			ps.setInt(1, userOn);
			ps.setString(2, userPassword);
			// 使用准备语句对象执行select语句，并将查询结果放入结果集中
			rs = ps.executeQuery();
			// 通过结果集判断用户是否登录成功
			if (rs.next()) {
				// 如果用户登录成功，将信息封装到UserMessage实体类对象中
				user.setUserId(rs.getInt("user_id"));
				user.setUserOn(rs.getInt("user_on"));
				user.setUserName(rs.getString("user_name"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserSex(rs.getString("user_sex"));
				user.setUserAge(rs.getInt("user_age"));
				user.setUserTel(rs.getString("user_tel"));
				user.setUserLoc(rs.getString("user_loc"));
				user.setUserRole(rs.getString("user_role"));
				return user;
			}
		} finally {
			DbUtils.close(rs, ps, conn);
		}
		return null;
	}

	/**
	 * 向表中添加新的用户信息。
	 * 
	 * @param userMessage 新的用户信息（用户名，密码，联系电话，邮箱）
	 * @return 添加成功返回大于0的整数，否则返回0
	 * @throws ClassNotFoundException 数据库驱动加载失败异常
	 * @throws SQLException           数据库操作异常
	 */
	public int insert(User userMessage) throws ClassNotFoundException, SQLException {
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
			String sql = "insert into user(user_on,user_name,user_password,user_sex,user_age,user_tel,user_loc,user_role) values(?,?,?,?,?,?,?,?)";
			// 创建语句准备对象，并设置准备语句对象将要执行的insert语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句对象中的问号
			ps.setInt(1, userMessage.getUserOn());
			ps.setString(2, userMessage.getUserName());
			ps.setString(3, userMessage.getUserPassword());
			ps.setString(4, userMessage.getUserSex());
			ps.setInt(5, userMessage.getUserAge());
			ps.setString(6, userMessage.getUserTel());
			ps.setString(7, userMessage.getUserLoc());
			ps.setString(8, userMessage.getUserRole());
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
	public int update(User user) throws ClassNotFoundException, SQLException {
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
			String sql = "update user set user_on=?,user_name=?,user_sex=?,user_age=?,user_tel=?,user_loc=?,user_role=? where user_id=?";
			// 创建语句准备对象，并设置准备语句对象将要执行的insert语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句对象中的问号
			ps.setInt(1, user.getUserOn());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getUserTel());
			ps.setString(6, user.getUserLoc());
			ps.setString(7, user.getUserRole());
			ps.setInt(8, user.getUserId());
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
	public int passupdate(String userId,String pass,String pass1) throws ClassNotFoundException, SQLException {
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
			String sql = "update user set user_password=? where user_id=? and user_password=?";
			// 创建语句准备对象，并设置准备语句对象将要执行的insert语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句对象中的问号
			ps.setString(1, pass1);
			ps.setString(2, userId);
			ps.setString(3, pass);
			
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
	public int delete(String userId) throws ClassNotFoundException, SQLException {
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
			String sql = "delete from user where user_id=?";
			// 创建语句准备对象，并设置准备语句对象将要执行的insert语句
			ps = conn.prepareStatement(sql);
			// 替换准备语句对象中的问号
			ps.setString(1,userId);
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
	public List<User> selectUser(String userName) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 获得数据库连接对象
			conn = DbUtils.getConnection();
			// 创建select语句，查询user表中所有数据
			StringBuilder sql = new StringBuilder(
					"select user_id,user_on,user_name,user_password,user_sex,user_age,user_tel,user_loc,user_role from user where 1=1 ");
			// 根据方法的形参传递数据，拼接select语句
			
			if (userName != null && !userName.trim().equals("")) {
				sql.append(" and user_name like ?");
			}
			ps = conn.prepareStatement(sql.toString());
			// 创建准备语句对象，并设置准备语句对象将要执行的语句
			if (userName != null && !userName.trim().equals("")) {
				ps.setString(1, "%" + userName + "%");
			}

			// 使用准备语句对象执行select语句，并将查询的结果存入到结果集中
			rs = ps.executeQuery();
			// 创建list集合，用于保存结果集中所有的数据
			List<User> list = new ArrayList<>();
			// 声明实体变量，用于保存结果集中的一行数据
			User user = null;
			// 使用循环将结果集中的数据封装对list集合中
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserOn(rs.getInt("user_on"));
				user.setUserName(rs.getString("user_name"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserSex(rs.getString("user_sex"));
				user.setUserAge(rs.getInt("user_age"));
				user.setUserTel(rs.getString("user_tel"));
				user.setUserLoc(rs.getString("user_loc"));
				String tempString = rs.getString("user_role").trim();
				if(Integer.parseInt(rs.getString("user_role"))== 1) {
					user.setUserRole("管理员");
				}
				else {
					user.setUserRole("普通用户");
				}
				list.add(user);
			}
			// 返回list集合
			return list;
		} finally {
			// 关闭数据库连接对象
			DbUtils.close(rs, ps, conn);
		}
	}
	public User selectContUser(String userId) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 获得数据库连接对象
			conn = DbUtils.getConnection();
			// 创建select语句，查询user表中所有数据
			StringBuilder sql = new StringBuilder(
					"select user_id,user_on,user_name,user_password,user_sex,user_age,user_tel,user_loc,user_role from user where user_id=?");
			// 根据方法的形参传递数据，拼接select语句
			
			ps = conn.prepareStatement(sql.toString());
			// 创建准备语句对象，并设置准备语句对象将要执行的语句
			if (userId != null && !userId.trim().equals("")) {
				ps.setString(1, userId );
			}

			// 使用准备语句对象执行select语句，并将查询的结果存入到结果集中
			rs = ps.executeQuery();
			// 创建list集合，用于保存结果集中所有的数据
			
			// 声明实体变量，用于保存结果集中的一行数据
			User user = new User();
			// 使用循环将结果集中的数据封装对list集合中
			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUserOn(rs.getInt("user_on"));
				user.setUserName(rs.getString("user_name"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserSex(rs.getString("user_sex"));
				user.setUserAge(rs.getInt("user_age"));
				user.setUserTel(rs.getString("user_tel"));
				user.setUserLoc(rs.getString("user_loc"));
				String tempString = rs.getString("user_role").trim();
				if(Integer.parseInt(rs.getString("user_role"))== 1) {
					user.setUserRole("管理员");
				}
				else {
					user.setUserRole("普通用户");
				}

			}
			// 返回list集合
			return user;
		} finally {
			// 关闭数据库连接对象
			DbUtils.close(rs, ps, conn);
		}
	}
}
