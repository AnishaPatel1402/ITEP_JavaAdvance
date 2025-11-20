package com.info.EcommerceMapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.info.EcommerceMapping.entity.Category;
import com.info.EcommerceMapping.utility.HibernateUtil;

public class CategoryDao {
	public static boolean addCategory(Category c) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try (Session session = sf.openSession();) {

			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public static Category findById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		try (Session session = sf.openSession();) {
			
			Category c = session.get(Category.class, id);
			if(c!=null) return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
