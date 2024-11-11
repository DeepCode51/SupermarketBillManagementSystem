package com.test.service;

/**
 * 用户模块的业务逻辑层
 * @author 超市账单
 *
 */

import java.sql.SQLException;
import java.util.List;



import com.test.dao.UserDao;
import com.test.entity.Bill;
import com.test.entity.User;

public class UserService {

	// 创建持久化层对象
	private UserDao userMessageDao = new UserDao();

	/**
	 * 查询满足条件的用户信息
	 * 
	 * @param userMessage 查询条件（用户姓名，联系电话）
	 * @return 返回一个java.util.List的实例
	 * @throws ClassNotFoundException 数据库驱动加载失败
	 * @throws SQLException           数据库操作异常
	 */
	public List<User> selectUser(String userName) throws ClassNotFoundException, SQLException {
		return this.userMessageDao.selectUser(userName);
	}
	
	public User selecContUser(String userId) throws ClassNotFoundException, SQLException {
		return this.userMessageDao.selectContUser(userId);
	}
	
	public int deleteUser(String userId) throws ClassNotFoundException, SQLException {
		return this.userMessageDao.delete(userId);
	}
	
	public int passupdate(String userId,String pass,String pass1) throws ClassNotFoundException, SQLException {
		return this.userMessageDao.passupdate(userId,pass,pass1);
	}
	
	public int update(User user) throws ClassNotFoundException, SQLException {
		return this.userMessageDao.update(user);
	}
	public int insert(User user) throws ClassNotFoundException, SQLException {
		return this.userMessageDao.insert(user);
	}

}
