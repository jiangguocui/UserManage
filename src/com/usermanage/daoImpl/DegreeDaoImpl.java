package com.usermanage.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.usermanage.dao.DegreeDao;
import com.usermanage.entity.Degree;
@Repository("degreeDao")
public class DegreeDaoImpl implements DegreeDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public void saveDegree(Degree degree) {
		this.hibernateTemplate.save(degree);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Degree> listDegree() {
		return this.hibernateTemplate.find("from Degree");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Degree> degreeById(String sql) {
		return this.hibernateTemplate.find(sql);
	}

	@Override
	public void updateDegree(Degree degree) {
		this.hibernateTemplate.update(degree);
	}

	@Override
	public Degree finddegreeById(long id) {
		return this.hibernateTemplate.get(Degree.class, id);
	}

	@Override
	public void deletedegree(long id) {
		this.hibernateTemplate.delete(this.hibernateTemplate.get(Degree.class, id));

	}

}
