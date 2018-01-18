package com.hu.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hu.ResultSetHander.IResultSetHandler;
import com.hu.jdbcUtil.JDBCUtil;
 
public class JDBCTemplate {
	public JDBCTemplate() {
	}

	public static int update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			// 获取连接对象
			conn = JDBCUtil.getConnection();
			// 创建语句对象
			ppst = conn.prepareStatement(sql);
			// 设置占位符参数
			for (int i = 0; i < params.length; i++) {	
				ppst.setObject(i + 1, params[i]);
			}
			// 执行语句
			return ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ppst, null);
		}
		return 0;
	}

	public static <T>T query(String sql, IResultSetHandler<T> rsh, Object... params) {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		try {
			// 获取连接对象
			conn = JDBCUtil.getConnection();
			// 创建语句对象
			ppst = conn.prepareStatement(sql);
			// 设置占位符点数
			for (int i = 0; i < params.length; i++) {
				ppst.setObject(i + 1, params[i]);
			}
			// 执行语句,接收结果集
			rs = ppst.executeQuery();
			// 处理结果集
			return rsh.Hander(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ppst, rs);
		}
		return null;
	}
}
