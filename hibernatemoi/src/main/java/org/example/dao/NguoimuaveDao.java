package org.example.dao;

import java.util.List;

import org.example.entity.Nguoimuave;

public interface NguoimuaveDao {
	public List<Nguoimuave> findAll();
	public boolean create(Nguoimuave nguoimuave);
	public boolean update(Nguoimuave nguoimuave,int id);
	public boolean delete(int id );
	public  Nguoimuave findbyId(int id);
}
