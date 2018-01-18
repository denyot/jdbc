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
	// 只需要加载一次驱动,所以放入静态代码块中,当JDBCUtil这份字节码被加载进JVM,就执行静态代码块
	static {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("db.properties");
		try {
			//从流中读取属性列表
			p.load(inStream);
			//加载注册驱动
			Class.forName(p.getProperty("DriverName"));
		} catch (IOException e1) {
			throw new RuntimeException("加载classpath根路径下的db.properties文件失败", e1);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("加载注册驱动失败", e);
		}
	}

	// 获取连接对象
	public static Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(p.getProperty("URL"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (SQLException e) {
			throw new RuntimeException("数据库连接失败");
		}
		return conn;
	}

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
