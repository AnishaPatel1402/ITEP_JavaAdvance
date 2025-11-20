package com.info.EcommerceMapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.info.EcommerceMapping.entity.Category;
import com.info.EcommerceMapping.entity.User;
import com.info.EcommerceMapping.utility.HibernateUtil;
import com.info.EcommerceMapping.utility.PasswordHashUtil;

import jakarta.persistence.TypedQuery;

public class UserDao {

	public static boolean registerUser(User u) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try(Session session = sf.openSession();){
			
			tx = session.beginTransaction();
			session.persist(u);
			tx.commit();
			return true;
		}catch(Exception e) {
			if(tx!=null && tx.isActive()) tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public static boolean loginUser(User u) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		try(Session session = sf.openSession();){
		TypedQuery<User> query = session.createQuery("from User where email=:email", User.class);
		query.setParameter("email", u.getEmail());
		
		User dbUser = query.getSingleResult();
		if(dbUser == null) return false;
		if(PasswordHashUtil.checkPassword(u.getPassword(), dbUser.getPassword())) return true;
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
