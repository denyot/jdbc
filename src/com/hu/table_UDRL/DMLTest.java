package com.hu.table_UDRL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * ����DML ���ݲ������ԣ�DML��Data Manipulation Language����
 * ������������INSERT��UPDATE��DELETE�����Ƿֱ�������ӣ��޸ĺ�ɾ�����е��С�Ҳ��Ϊ������ѯ���ԡ�
 * 
 */
public class DMLTest {
	@Test
	// ����Insert���
	public void testInsert() {
		// Insert���
		String sql = "insert into actress(name,age) values('��Ұ����',28)";
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

	@Test
	// ����update
	public void testUpdate() {
		// Update���
		String sql = "update actress set name='����δ��',age=29 where id= 2";
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

	@Test
	// ����delete
	public void testDelete() {
		// delete���
		String sql = "delete from actress where id = 1";
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
