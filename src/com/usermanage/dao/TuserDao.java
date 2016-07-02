package com.usermanage.dao;

import java.util.List;

import com.usermanage.entity.Tuser;

public interface TuserDao {
	public void saveTuser(Tuser tuser);
	public List<Tuser> listTuser();
	public List<Tuser> TuserBysql(String sql);
	public void updateTuser(Tuser tuser);
	public Tuser findTuserById(long id);
	public void deleteTuser(long id);
}
