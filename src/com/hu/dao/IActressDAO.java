package com.hu.dao;

import java.util.List;

import com.hu.domain.Actress;

public interface IActressDAO {
	
	public void save(Actress actress);

	/**
	 * ɾ��ָ����id��Ů��Ա��Ϣ
	 * 
	 * @param id
	 *            ָ����id
	 */
	public void delete(long id);

	/**
	 * ����ָ��id��Ů��Ա��Ϣ
	 * 
	 * @param id
	 *            ָ����id
	 * @param name
	 *            �µ�����
	 * @param age
	 *            �µ�����
	 */
	public void update(long id, Actress newActress);

	/**
	 * ��ȡָ��id��Ů��Ա��Ϣ
	 * 
	 * @param id
	 *            ָ����id
	 * @return ����Ů��Ա����
	 */
	public Actress get(long id);

	/**
	 * ��ȡ��������Ů��Ա��Ϣ
	 * 
	 * @return ����Ů��Ա����List
	 */
	public List<Actress> list();
}
