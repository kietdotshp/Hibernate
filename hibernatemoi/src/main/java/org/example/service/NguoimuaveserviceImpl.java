package org.example.service;

import java.util.List;

import org.example.entity.Nguoimuave;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

public class NguoimuaveserviceImpl implements Nguoimuaveservice {
	
	
	@Override
	public List<Nguoimuave> findAll(Nguoimuave nguoimuave) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	      session.beginTransaction();
	      List<Nguoimuave> result = session.createQuery("select t from Nguoimuave t").list();
	      session.getTransaction().commit();
	      return result;
	    } catch (HibernateException e) {
	    	session.getTransaction().rollback();
	    } finally {
	    	session.close();
	    }
	    return null;
	}

	@Override
	public boolean create(Nguoimuave nguoimuave) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
		    try {
		      session.beginTransaction();
		      session.save(nguoimuave);
		      session.getTransaction().commit();
		      return true;
		    } catch (HibernateException e) {
		      session.getTransaction().rollback();
		    } finally {
		      session.close();
		    }
		    return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Nguoimuave nguoimuave, int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("update Nguoimuave set hoTen =:HoTen, diaChi=:DiaChi, sdt=:sdt,loaiNguoi= :LoaiNguoi " +
    				" where id = :ID")
					.setParameter("ID", id)
					.setParameter("HoTen", nguoimuave.getHoTen())
					.setParameter("DiaChi", nguoimuave.getDiaChi())
					.setParameter("sdt", nguoimuave.getSdt())
					.setParameter("LoaiNguoi", nguoimuave.getLoaiNguoi());
			int result = query.executeUpdate();
			if(result==1)
				return true;
			else
				return false;
		}  catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
		return false;
	}

	@Override
	public boolean delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Nguoimuave nguoimuave = session.load(Nguoimuave.class, id);
            session.delete(nguoimuave);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
	}

	@Override
	public Nguoimuave findbyId(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Nguoimuave> query = session.createQuery("select t from Nguoimuave t where t.id = :id");
            query.setParameter("id", id);
            return !query.list().isEmpty() ? query.getSingleResult() : null;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
	}
	public static List<Nguoimuave> GetAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List<Nguoimuave> nguoiMuaVes = (List<Nguoimuave>) session.createQuery("from Nguoimuave").list();
			return nguoiMuaVes;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return null;
	}
}
