package com.hu.connectDatabase;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

//�����������ݿ�
public class ConnectDatabassTest {
	@Test
	// �����������ݿ�
	public void testConnect() throws ClassNotFoundException, SQLException {
		// ����ע������
		Class.forName("com.mysql.jdbc.Driver");
		// ��ȡ���Ӷ���
		DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
	}

}
