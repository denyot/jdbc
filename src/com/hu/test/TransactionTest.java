package com.hu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.hu.jdbcUtil.JDBCUtil;

//����������
public class TransactionTest {
	@Test
	public void test1() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from actress where name=? and money>=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "���ջ�");
			ps.setInt(2, 1000);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new RuntimeException("�˻�����");
			}
			conn.setAutoCommit(false);
			sql = "update actress set money=money-? where name=?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, 1000);
			ps.setString(2, "���ջ�");
			ps.executeUpdate();
			sql = "update actress set money=money+? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, 1000);
			ps.setInt(2, 13);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
	}
}
