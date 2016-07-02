package com.usermanage.dao;

import java.util.List;

import com.usermanage.entity.Tmanager;

public interface TmanagerDao {
	public void saveTmanager(Tmanager tmanager);
	public List<Tmanager> listTmanager();
	public List<Tmanager> TmanagerBysql(String sql);
	public void updateTmanager(Tmanager tmanager);
	public Tmanager findTmanagerById(long id);
	public void deleteTmanager(long id);
}
