package com.hu.table_UDRL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 测试DML 数据操作语言（DML：Data Manipulation Language）：
 * 其语句包括动词INSERT，UPDATE和DELETE。它们分别用于添加，修改和删除表中的行。也称为动作查询语言。
 * 
 */
public class DMLTest {
	@Test
	// 测试Insert添加
	public void testInsert() {
		// Insert语句
		String sql = "insert into actress(name,age) values('星野景子',28)";
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

	@Test
	// 测试update
	public void testUpdate() {
		// Update语句
		String sql = "update actress set name='大桥未久',age=29 where id= 2";
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

	@Test
	// 测试delete
	public void testDelete() {
		// delete语句
		String sql = "delete from actress where id = 1";
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
