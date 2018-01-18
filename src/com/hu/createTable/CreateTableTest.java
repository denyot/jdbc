package com.hu.createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

//���Դ�����
public class CreateTableTest {

	@Test
	// ���Դ�����
	public void TestCreateTable() {
		// Ҫִ�е����
		String sql = "CREATE table student(id bigint primary key auto_increment,name char(20),age int)";
		// ��ȡ���Ӷ���
		Connection conn = null;
		// ����������
		Statement stm = null;
		try {
			// ����ע������
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
			stm = conn.createStatement();
			// ִ�����
			stm.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
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
