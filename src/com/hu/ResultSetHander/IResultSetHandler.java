package com.hu.ResultSetHander;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {
	/**
	 * ��������
	 * @param rs ��������
	 * @return	����֮�󷵻صĶ���(��������/���϶���)
	 */
	T Hander(ResultSet rs) throws Exception;
}
