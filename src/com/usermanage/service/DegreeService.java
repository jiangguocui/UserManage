package com.usermanage.service;

import java.util.List;

import com.usermanage.entity.Degree;

public interface DegreeService {
	public void saveDegree(Degree degree);
	public List<Degree> listDegree();
	public List<Degree> degreeById(String sql);
	public void updateDegree(Degree degree);
	public Degree finddegreeById(long id);
	public void deletedegree(long id);
}
