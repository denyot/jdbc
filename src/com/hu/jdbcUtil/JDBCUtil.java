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

	// 获取DPCP的DataSource对象
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

	// 获取连接对象
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("获取连接异常", e);
		}
	}

	/*// 获取DPCP的DataSource对象
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

	// 获取连接对象
	public static Connection getConnection() {
		try {
			return JDBCUtil.getDataSource().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("获取连接异常", e);
		}
	}*/

	// 关闭资源并处理异常
	public static void close(Connection conn, PreparedStatement ppst, ResultSet rs) {
		try {
			// 关闭资源
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
	 * 关闭Statement语句资源
	 * 
	 * @param conn
	 * @param ppst
	 * @param rs
	 */
	public static void close(Connection conn, Statement ppst, ResultSet rs) {
		try {
			// 关闭资源
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
