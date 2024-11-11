package com.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * ???????????
 * @author 
 * @throws ClassNotFoundException
 * 			????????????????
 * @
 *
 */
public class DbUtils {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		//?????????????
		Class.forName("com.mysql.jdbc.Driver");
		//???????????????
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/graduation_supermarket2?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true"
				,"root","123456");
		//?????????????????
		conn.setAutoCommit(false);
		//????????????????
		return conn;
	}
	
	public static void close(ResultSet rs,Statement stat,Connection conn) throws SQLException{
		if (rs!=null) {
			rs.close();
		}
		if (stat!=null) {
			stat.close();
		}
		if (conn!=null) {
			conn.close();
		}
	}
}
