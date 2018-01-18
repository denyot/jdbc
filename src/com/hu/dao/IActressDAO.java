package com.hu.dao;

import java.util.List;

import com.hu.domain.Actress;

public interface IActressDAO {
	
	public void save(Actress actress);

	/**
	 * 删除指定的id的女演员信息
	 * 
	 * @param id
	 *            指定的id
	 */
	public void delete(long id);

	/**
	 * 更新指定id的女演员信息
	 * 
	 * @param id
	 *            指定的id
	 * @param name
	 *            新的名字
	 * @param age
	 *            新的年龄
	 */
	public void update(long id, Actress newActress);

	/**
	 * 获取指定id的女演员信息
	 * 
	 * @param id
	 *            指定的id
	 * @return 返回女演员对象
	 */
	public Actress get(long id);

	/**
	 * 获取表中所有女演员信息
	 * 
	 * @return 返回女演员对象List
	 */
	public List<Actress> list();
}
