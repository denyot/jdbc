package com.hu.jdbcUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;


import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {

	// ��ȡDPCP��DataSource����
	public static DataSource dataSource;
	static {

		try {
			Properties p = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream inStream = loader.getResourceAsStream("db.properties");
			p.load(inStream);
			dataSource = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ��ȡ���Ӷ���
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("��ȡ�����쳣", e);
		}
	}

	/*// ��ȡDPCP��DataSource����
	public static DataSource getDataSource() {
		Properties p = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("db.properties");
		try {
			p.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(p.getProperty("driverClassName"));
		ds.setUsername(p.getProperty("username"));
		ds.setPassword(p.getProperty("password"));
		ds.setUrl(p.getProperty("url"));
		return ds;
	}

	// ��ȡ���Ӷ���
	public static Connection getConnection() {
		try {
			return JDBCUtil.getDataSource().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("��ȡ�����쳣", e);
		}
	}*/

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
	 * 
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
