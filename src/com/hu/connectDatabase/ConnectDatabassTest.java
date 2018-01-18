package com.hu.connectDatabase;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

//测试连接数据库
public class ConnectDatabassTest {
	@Test
	// 测试连接数据库
	public void testConnect() throws ClassNotFoundException, SQLException {
		// 加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接对象
		DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
	}

}
