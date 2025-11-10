package com.StudentHQL.StudentHQL.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHqlUtility {
	private static SessionFactory sessionFactory = null;
	public static SessionFactory getSessionFactory() {
		try {
			if(sessionFactory == null) sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
