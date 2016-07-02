package com.usermanage.service;

import java.util.List;

import com.usermanage.entity.Political;

public interface PoliticalService {
	public void savePolitical(Political political);
	public List<Political> listPolitical();
	public List<Political> PoliticalBysql(String sql);
	public void updatePolitical(Political political);
	public Political findPoliticalById(long id);
	public void deletePolitical(long id);
}
