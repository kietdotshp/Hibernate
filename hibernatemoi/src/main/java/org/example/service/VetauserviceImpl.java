package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.entity.Nguoimuave;
import org.example.entity.Vetau;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

public class VetauserviceImpl implements Vetauservices {

	@Override
//	Session session = HibernateUtil.getSessionFactory().openSession();
//    try {
//      session.beginTransaction();
//      List<Nguoimuave> result = session.createQuery("select t from Nguoimuave t").list();
//      session.getTransaction().commit();
//      return result;
//    } catch (HibernateException e) {
//    	session.getTransaction().rollback();
//    } finally {
//    	session.close();
//    }
//    return null;
//}
	public List<Vetau> findAll(Vetau vetau) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Vetau> resultVetaus = session.createQuery("select v from Vetau v").list();
			session.getTransaction().commit();
			return resultVetaus;
		} catch (HibernateException e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}
	public static List<Vetau> findAll1(Vetau vetau) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Vetau> resultVetaus = session.createQuery("select v from Vetau v").list();
			session.getTransaction().commit();
			return resultVetaus;
		} catch (HibernateException e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean CreateVetau(Vetau vetau) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				session.getTransaction().begin();
				session.save(vetau);
				session.getTransaction().commit();
				return true;
			} catch (HibernateException e) {
				// TODO: handle exception
				session.getTransaction().rollback();
			}finally {
				session.close();
			}
			 return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean Update(Vetau vetau) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Vetau vetau) {
		// TODO Auto-generated method stub
		return false;
	}


	public static ArrayList<Vetau> GetAllVe(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List<Vetau> listvetau = (List<Vetau>) session.createQuery("from Vetau").list();
			return (ArrayList<Vetau>) listvetau;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return null;
	}
	@Override
	public Vetau findbyIdVe(int veId) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Vetau> query = session.createQuery("select t from Vetau t where t.veId = :veId");
            query.setParameter("veId", veId);
            return query.getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
		
	}
}
