package com.hu.table_UDRL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DQLTest {
    @Test
    // 查询所有女演员信息
    public void testQueryAll() {
        // Query语句
        String sql = "select * from actress";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            // 加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
            // 创建语句对象
            stm = conn.createStatement();
            // 执行语句,接收结果集
            rs = stm.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
                long id = rs.getLong("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                System.out.println(id + name + age);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            // 关闭资源
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
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

    @Test
    // 查询表中有多少条数据
    public void testGetCount() {
        // Query语句
        String sql = "select count(id) count from actress";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            // 加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
            // 创建语句对象
            stm = conn.createStatement();
            // 执行语句,接收结果集
            rs = stm.executeQuery(sql);
            // 处理结果集
            if (rs.next()) {
                System.out.println(rs.getLong("count"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            // 关闭资源
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
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

    @Test
    // 查询指定id女演员信息
    public void testQueryOne() {
        // Query语句
        String sql = "select * from actress where id = 3";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            // 加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
            // 创建语句对象
            stm = conn.createStatement();
            // 执行语句,接收结果集
            rs = stm.executeQuery(sql);
            // 处理结果集
            if (rs.next()) {
                long id = rs.getLong("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                System.out.println(id + name + age);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            // 关闭资源
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
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
