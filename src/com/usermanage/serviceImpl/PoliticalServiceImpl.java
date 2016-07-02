package com.usermanage.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.usermanage.dao.PoliticalDao;
import com.usermanage.entity.Political;
import com.usermanage.service.PoliticalService;
@Repository("politicalService")
public class PoliticalServiceImpl implements PoliticalService {
	@Resource
	private PoliticalDao politicalDao;
	@Override
	public void savePolitical(Political political) {
		this.politicalDao.savePolitical(political);
	}

	@Override
	public List<Political> listPolitical() {
		return this.politicalDao.listPolitical();
	}

	@Override
	public List<Political> PoliticalBysql(String sql) {
		return this.politicalDao.PoliticalBysql(sql);
	}

	@Override
	public void updatePolitical(Political political) {
		this.politicalDao.updatePolitical(political);
	}

	@Override
	public Political findPoliticalById(long id) {
		return this.politicalDao.findPoliticalById(id);
	}

	@Override
	public void deletePolitical(long id) {
		this.politicalDao.deletePolitical(id);
	}

}
