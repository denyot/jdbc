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
			// ��ȡ���Ӷ���
			conn = JDBCUtil.getConnection();
			// ����������
			ppst = conn.prepareStatement(sql);
			// ����ռλ������
			for (int i = 0; i < params.length; i++) {	
				ppst.setObject(i + 1, params[i]);
			}
			// ִ�����
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
			// ��ȡ���Ӷ���
			conn = JDBCUtil.getConnection();
			// ����������
			ppst = conn.prepareStatement(sql);
			// ����ռλ������
			for (int i = 0; i < params.length; i++) {
				ppst.setObject(i + 1, params[i]);
			}
			// ִ�����,���ս����
			rs = ppst.executeQuery();
			// ��������
			return rsh.Hander(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ppst, rs);
		}
		return null;
	}
}
