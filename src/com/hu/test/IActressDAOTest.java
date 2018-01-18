package com.hu.test;

import java.util.List;

import org.junit.Test;

import com.hu.dao.IActressDAO;
import com.hu.dao.imlp.ActressDAOImpl;
import com.hu.domain.Actress;

public class IActressDAOTest {
	private IActressDAO dao = new ActressDAOImpl();

	@Test
	public void testSave() {
		Actress actress = new Actress();
		actress.setName("œ£µ∫");
		actress.setAge(18);
		dao.save(actress);
	}

	@Test
	public void testDelete() {
		dao.delete(20l);
	}

	@Test
	public void testUpdate() {
		Actress newActress = new Actress();
		newActress.setAge(21);
		newActress.setName("À…µ∫∑„");
		dao.update(2l, newActress);
	}

	@Test
	public void testGet() {
		Actress actress = dao.get(12);
		System.out.println(actress);

	}

	@Test
	public void testList() {
		List<Actress> list = dao.list();
		for (Actress actress : list) {
			System.out.println(actress);
		}
	}

}
