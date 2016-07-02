package com.usermanage.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.usermanage.dao.PoliticalDao;
import com.usermanage.entity.Political;
@Repository("politicalDao")
public class PoliticalDaoImpl implements PoliticalDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public void savePolitical(com.usermanage.entity.Political political) {
		this.hibernateTemplate.save(political);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.usermanage.entity.Political> listPolitical() {
		return this.hibernateTemplate.find("from Political");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.usermanage.entity.Political> PoliticalBysql(String sql) {
		return this.hibernateTemplate.find(sql);
	}

	@Override
	public void updatePolitical(com.usermanage.entity.Political political) {
		this.hibernateTemplate.update(political);
	}

	@Override
	public com.usermanage.entity.Political findPoliticalById(long id) {
		return this.hibernateTemplate.get(Political.class, id);
	}

	@Override
	public void deletePolitical(long id) {
		this.hibernateTemplate.delete(this.hibernateTemplate.get(Political.class, id));
	}

}
