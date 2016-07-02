package com.usermanage.daoImpl;

import java.util.List;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.management.Query;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.usermanage.dao.TuserDao;
import com.usermanage.entity.Tuser;
@Repository("tuserDao")
public class TuserDaoImpl implements TuserDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public void saveTuser(Tuser tuser) {
		this.hibernateTemplate.save(tuser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tuser> listTuser() {
		return this.hibernateTemplate.find("from Tuser");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tuser> TuserBysql(String sql) {
		return this.hibernateTemplate.find(sql);
/*		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(sql)
				.setString("userPhone", userPhone).setString("userPassword", userPassword).
			*/
		
	}

	@Override
	public void updateTuser(Tuser tuser) {
		this.hibernateTemplate.update(tuser);
	}

	@Override
	public Tuser findTuserById(long id) {
		return this.hibernateTemplate.get(Tuser.class, id);
	}

	@Override
	public void deleteTuser(long id) {
		this.hibernateTemplate.delete(this.hibernateTemplate.get(Tuser.class, id));
	}

}
