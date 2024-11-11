package com.test.service;

/**
 * 用户模块的业务逻辑层
 * @author 超市账单
 *
 */

import java.sql.SQLException;
import java.util.List;



import com.test.dao.ProviderDao;
import com.test.dao.UserDao;
import com.test.entity.Provider;
import com.test.entity.User;

public class ProviderService {

	// 创建持久化层对象
	private ProviderDao providerdao = new ProviderDao();

	/**
	 * 查询满足条件的用户信息
	 * 
	 * @param userMessage 查询条件（用户姓名，联系电话）
	 * @return 返回一个java.util.List的实例
	 * @throws ClassNotFoundException 数据库驱动加载失败
	 * @throws SQLException           数据库操作异常
	 */
	public List<Provider> selectProvider(String providerName,String providerDescribe) throws ClassNotFoundException, SQLException {
		return this.providerdao.selectProvider(providerName,providerDescribe);
	}
	
	public Provider selectContProvider(String providerId) throws ClassNotFoundException, SQLException {
		return this.providerdao.selectContProvider(providerId);
	}
	
	public int deleteProvider(String ProviderId) throws ClassNotFoundException, SQLException {
		return this.providerdao.delete(ProviderId);
	}
	
	public int insert(Provider provider) throws ClassNotFoundException, SQLException {
		return this.providerdao.insert(provider);
	}

}
