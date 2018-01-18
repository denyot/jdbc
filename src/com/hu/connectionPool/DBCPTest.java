package com.hu.connectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DBCPTest {
	// 获取DPCP的DataSource对象
	public DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("admin");
		ds.setUrl("jdbc:mysql://localhost:3306/jdbcdemo");
		return ds;
	}

	@Test
	public void test1() throws SQLException {
		String sql = "select * from actress";
		Connection conn = this.getDataSource().getConnection();
		PreparedStatement ppst = conn.prepareStatement(sql);
		ResultSet rs = ppst.executeQuery();
		while (rs.next()) {
			long id = rs.getLong("id");
			int age = rs.getInt("age");
			String name = rs.getString("name");
			System.out.println(id+name+age);
		}
		ppst.close();
		conn.close();

	}
}
