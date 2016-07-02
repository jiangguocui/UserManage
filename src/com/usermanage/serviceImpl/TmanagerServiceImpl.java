package com.usermanage.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.usermanage.dao.TmanagerDao;
import com.usermanage.entity.Tmanager;
import com.usermanage.service.TmanagerService;
@Repository("tmanagerService")
public class TmanagerServiceImpl implements TmanagerService {
	@Resource
	private TmanagerDao tmanagerDao;
	@Override
	public void saveTmanager(Tmanager tmanager) {
		this.tmanagerDao.saveTmanager(tmanager);
	}

	@Override
	public List<Tmanager> listTmanager() {
		return this.tmanagerDao.listTmanager();
	}

	@Override
	public List<Tmanager> TmanagerBysql(String sql) {
		return this.tmanagerDao.TmanagerBysql(sql);
	}

	@Override
	public void updateTmanager(Tmanager tmanager) {
		this.tmanagerDao.updateTmanager(tmanager);
	}

	@Override
	public Tmanager findTmanagerById(long id) {
		return this.tmanagerDao.findTmanagerById(id);
	}

	@Override
	public void deleteTmanager(long id) {
		this.tmanagerDao.deleteTmanager(id);
	}

}
