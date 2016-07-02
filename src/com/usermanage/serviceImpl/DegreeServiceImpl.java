package com.usermanage.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.usermanage.dao.DegreeDao;
import com.usermanage.entity.Degree;
import com.usermanage.service.DegreeService;
@Repository("degreeService")
public class DegreeServiceImpl implements DegreeService {
	@Resource
	private DegreeDao degreeDao;
	@Override
	public void saveDegree(Degree degree) {
		this.degreeDao.saveDegree(degree);
	}

	@Override
	public List<Degree> listDegree() {
		return this.degreeDao.listDegree();
	}

	@Override
	public List<Degree> degreeById(String sql) {
		return this.degreeDao.degreeById(sql);
	}

	@Override
	public void updateDegree(Degree degree) {
		this.degreeDao.updateDegree(degree);
	}

	@Override
	public Degree finddegreeById(long id) {
		return this.degreeDao.finddegreeById(id);
	}

	@Override
	public void deletedegree(long id) {
		this.degreeDao.deletedegree(id);
	}

}
