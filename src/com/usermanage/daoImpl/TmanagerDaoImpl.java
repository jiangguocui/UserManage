package com.usermanage.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.usermanage.dao.TmanagerDao;
import com.usermanage.entity.Tmanager;
@Repository("tmanager")
public class TmanagerDaoImpl implements TmanagerDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public void saveTmanager(com.usermanage.entity.Tmanager tmanager) {
		this.hibernateTemplate.save(tmanager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.usermanage.entity.Tmanager> listTmanager() {
		return this.hibernateTemplate.find("from Tmanager");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.usermanage.entity.Tmanager> TmanagerBysql(String sql) {
		return this.hibernateTemplate.find(sql);
	}

	@Override
	public void updateTmanager(com.usermanage.entity.Tmanager tmanager) {
		this.hibernateTemplate.update(tmanager);
	}

	@Override
	public com.usermanage.entity.Tmanager findTmanagerById(long id) {
		return this.hibernateTemplate.get(Tmanager.class, id);
	}

	@Override
	public void deleteTmanager(long id) {
		// TODO Auto-generated method stub

	}

}
