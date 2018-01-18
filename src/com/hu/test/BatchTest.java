package com.hu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import com.hu.jdbcUtil.JDBCUtil;

public class BatchTest {
	@Test
	// 使用Statement,逐个处理
	// 9041 ms
	public void testsaveByStatement() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		Statement st = conn.createStatement();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			String sql = "insert into actress(name,age) values('美女'," + i + ")";
			st.execute(sql);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
		JDBCUtil.close(conn, st, null);

	}

	@Test
	// 使用Statement,批处理
	// 8746ms
	public void testBatchBystatement() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		Statement st = conn.createStatement();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			String sql = "insert into actress(name,age) values('美女'," + i + ")";
			st.addBatch(sql);
			if (i % 200 == 0) {
				st.executeBatch();
				st.clearBatch();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
		JDBCUtil.close(conn, st, null);
	}

	@Test
	// 使用preparedStatement,逐个处理
	// 9104
	public void testsaveByPreparedStatement() throws Exception {
		String sql = "insert into actress(name,age) values('美女',?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ppst = conn.prepareStatement(sql);
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			ppst.setInt(1, i);
			ppst.executeUpdate();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
		JDBCUtil.close(conn, ppst, null);
	}

	@Test
	// 使用preparedStament,批处理
	// 8426
	public void testBatchBysPreparedtatement() throws Exception {
		String sql = "insert into actress(name,age) values('美女',?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ppst = conn.prepareStatement(sql);
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			ppst.setInt(1, i);
			ppst.addBatch();
			if (i % 200 == 0) {
				ppst.executeBatch();
				ppst.clearBatch();
				ppst.clearParameters();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
		JDBCUtil.close(conn, ppst, null);
	}

}
