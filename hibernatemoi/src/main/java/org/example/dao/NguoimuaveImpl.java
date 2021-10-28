package org.example.dao;

import java.util.List;

import org.example.entity.Nguoimuave;
import org.example.util.HibernateUtil;
import org.springframework.boot.web.servlet.server.Session;

public class NguoimuaveImpl implements NguoimuaveDao{

	@Override
	public List<Nguoimuave> findAll() {
		// TODO Auto-generated method stub
			org.hibernate.Session session  = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			List<Nguoimuave>  nguoimuave1 = session.createQuery("from Student").list();
			session.getTransaction().commit();
			return nguoimuave1;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean create(Nguoimuave nguoimuave) {
		try {
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Nguoimuave nguoimuave, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Nguoimuave findbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
