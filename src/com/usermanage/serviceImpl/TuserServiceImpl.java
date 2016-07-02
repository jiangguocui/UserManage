package com.usermanage.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.usermanage.dao.TuserDao;
import com.usermanage.entity.Tuser;
import com.usermanage.service.TuserService;
@Repository("tuserService")
public class TuserServiceImpl implements TuserService {
	@Resource
	private TuserDao tuserDao;
	@Override
	public void saveTuser(Tuser tuser) {
		this.tuserDao.saveTuser(tuser);
	}

	@Override
	public List<Tuser> listTuser() {
		return this.tuserDao.listTuser();
	}

	@Override
	public List<Tuser> TuserBysql(String sql) {
		return this.tuserDao.TuserBysql(sql);
	}

	@Override
	public void updateTuser(Tuser tuser) {
		this.tuserDao.updateTuser(tuser);
	}

	@Override
	public Tuser findTuserById(long id) {
		return this.tuserDao.findTuserById(id);
	}

	@Override
	public void deleteTuser(long id) {
		this.tuserDao.deleteTuser(id);
	}

}
