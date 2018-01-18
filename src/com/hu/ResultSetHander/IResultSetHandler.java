package com.hu.ResultSetHander;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {
	/**
	 * 处理结果集
	 * @param rs 处理集对象
	 * @return	处理之后返回的对象(单个对象/集合对象)
	 */
	T Hander(ResultSet rs) throws Exception;
}
