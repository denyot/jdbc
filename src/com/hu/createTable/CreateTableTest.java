package com.hu.createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

//测试创建表
public class CreateTableTest {

	@Test
	// 测试创建表
	public void TestCreateTable() {
		// 要执行的语句
		String sql = "CREATE table student(id bigint primary key auto_increment,name char(20),age int)";
		// 获取连接对象
		Connection conn = null;
		// 创建语句对象
		Statement stm = null;
		try {
			// 加载注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
			stm = conn.createStatement();
			// 执行语句
			stm.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
