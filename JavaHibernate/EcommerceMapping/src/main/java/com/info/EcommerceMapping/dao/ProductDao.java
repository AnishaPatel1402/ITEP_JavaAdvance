package com.info.EcommerceMapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.info.EcommerceMapping.entity.Product;
import com.info.EcommerceMapping.utility.HibernateUtil;

public class ProductDao {

	public static boolean addProduct(Product p) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try(Session session = sf.openSession();){
			
			tx = session.beginTransaction();
			session.persist(p);
			tx.commit();
			return true;
		}catch(Exception e) {
			if(tx!=null && tx.isActive()) tx.rollback();
			e.printStackTrace();
		}
		return false;
	}


}
