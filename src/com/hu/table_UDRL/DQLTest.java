package com.hu.table_UDRL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DQLTest {
    @Test
    // ��ѯ����Ů��Ա��Ϣ
    public void testQueryAll() {
        // Query���
        String sql = "select * from actress";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            // ����ע������
            Class.forName("com.mysql.jdbc.Driver");
            // ��ȡ���Ӷ���
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
            // ����������
            stm = conn.createStatement();
            // ִ�����,���ս����
            rs = stm.executeQuery(sql);
            // ��������
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
            // �ر���Դ
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
    // ��ѯ�����ж���������
    public void testGetCount() {
        // Query���
        String sql = "select count(id) count from actress";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            // ����ע������
            Class.forName("com.mysql.jdbc.Driver");
            // ��ȡ���Ӷ���
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
            // ����������
            stm = conn.createStatement();
            // ִ�����,���ս����
            rs = stm.executeQuery(sql);
            // ��������
            if (rs.next()) {
                System.out.println(rs.getLong("count"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            // �ر���Դ
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
    // ��ѯָ��idŮ��Ա��Ϣ
    public void testQueryOne() {
        // Query���
        String sql = "select * from actress where id = 3";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            // ����ע������
            Class.forName("com.mysql.jdbc.Driver");
            // ��ȡ���Ӷ���
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "admin");
            // ����������
            stm = conn.createStatement();
            // ִ�����,���ս����
            rs = stm.executeQuery(sql);
            // ��������
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
            // �ر���Դ
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
