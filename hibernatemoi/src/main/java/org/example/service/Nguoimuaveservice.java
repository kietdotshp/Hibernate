package org.example.service;

import java.util.List;

import org.example.entity.Nguoimuave;
import org.hibernate.Session;

public interface Nguoimuaveservice {
	public List<Nguoimuave> findAll(Nguoimuave nguoimuave);
	public boolean create(Nguoimuave nguoimuave);
	public boolean update(Nguoimuave nguoimuave,int id);
	public boolean delete(int id );
	public  Nguoimuave findbyId(int id);
	
}
