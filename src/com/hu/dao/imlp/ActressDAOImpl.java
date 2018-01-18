package com.hu.dao.imlp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hu.JDBCTemplate.JDBCTemplate;
import com.hu.ResultSetHander.IResultSetHandler;
import com.hu.dao.IActressDAO;
import com.hu.domain.Actress;

public class ActressDAOImpl implements IActressDAO {

	@Override
	public void save(Actress actress) {
		String sql = "insert into actress(name,age) values(?,?)";
		JDBCTemplate.update(sql, actress.getName(), actress.getAge());
	}

	@Override
	public void delete(long id) {
		String sql = "delete from actress where id =?";
		JDBCTemplate.update(sql, id);
	}

	@Override
	public void update(long id, Actress newActress) {
		String sql = "update actress set name=?,age=? where id= ?";
		JDBCTemplate.update(sql, newActress.getName(), newActress.getAge(), id);
	}

	@Override
	public Actress get(long id) {
		String sql = "select * from actress where id = ?";
		List<Actress> list = JDBCTemplate.query(sql, new ActressResultSetHandler(), id);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Actress> list() {
		String sql = "select * from actress";
		return JDBCTemplate.query(sql, new ActressResultSetHandler());
	}
	
	class ActressResultSetHandler implements IResultSetHandler<List<Actress>> {
		public List<Actress> Hander(ResultSet rs) throws Exception {
			List<Actress> list = new ArrayList<>();
			while (rs.next()) {
				Actress actress = new Actress();
				actress.setId(rs.getLong("id"));
				actress.setAge(rs.getInt("age"));
				actress.setName(rs.getString("name"));
				list.add(actress);
			}
			return list;
		}
	}
}
