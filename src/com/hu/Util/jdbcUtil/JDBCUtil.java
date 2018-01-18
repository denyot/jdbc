package com.hu.Util.jdbcUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	private static Properties p = new Properties();
	// ֻ��Ҫ����һ������,���Է��뾲̬�������,��JDBCUtil����ֽ��뱻���ؽ�JVM,��ִ�о�̬�����
	static {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("db.properties");
		try {
			//�����ж�ȡ�����б�
			p.load(inStream);
			//����ע������
			Class.forName(p.getProperty("DriverName"));
		} catch (IOException e1) {
			throw new RuntimeException("����classpath��·���µ�db.properties�ļ�ʧ��", e1);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("����ע������ʧ��", e);
		}
	}

	// ��ȡ���Ӷ���
	public static Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(p.getProperty("URL"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (SQLException e) {
			throw new RuntimeException("���ݿ�����ʧ��");
		}
		return conn;
	}

	// �ر���Դ�������쳣
	public static void close(Connection conn, PreparedStatement ppst, ResultSet rs) {
		try {
			// �ر���Դ
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * �ر�Statement�����Դ
	 * @param conn
	 * @param ppst
	 * @param rs
	 */
		public static void close(Connection conn, Statement ppst, ResultSet rs) {
			try {
				// �ر���Դ
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ppst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

}
