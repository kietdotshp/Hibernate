package org.example.service;

import java.util.Iterator;
import java.util.List;

import org.example.entity.Hoadon;
import org.example.entity.Nguoimuave;
import org.example.util.CollectionUtils;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Hoadonservices {
	public static void addHoadon(List<Hoadon> hoaDonList) {
		if(CollectionUtils.isEmty(hoaDonList)) {
			return;
		}
		Session session  = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			for (Hoadon hoadon : hoaDonList) {
				session.save(hoadon);
				
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
	}
	
	public List<Hoadon> findAllHD(Hoadon hoadon2) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	      session.beginTransaction();
	      List<Hoadon> result = session.createQuery("select h from Hoadon h").list();
	      session.getTransaction().commit();
	      return result ;
	    } catch (HibernateException e) {
	    	session.getTransaction().rollback();
	    } finally {
	    	session.close();
	    }
	    return null;
	}
	public static List<Hoadon> getAllHoadon(){
		Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	      session.beginTransaction();
	      List<Hoadon> result = session.createQuery("select h from Hoadon h").list();
	      session.getTransaction().commit();
	      return result ;
	    } catch (HibernateException e) {
	    	session.getTransaction().rollback();
	    } finally {
	    	session.close();
	    }
	    return null;
	}


}
