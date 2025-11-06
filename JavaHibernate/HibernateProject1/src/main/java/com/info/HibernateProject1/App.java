package com.info.HibernateProject1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.info.HibernateProject1.entity.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//1
        Configuration configuration = new Configuration();
        
        configuration.configure();
        
        //2
        SessionFactory sf = configuration.buildSessionFactory();
        
        //3 
        Session session = sf.openSession();
        
        
        //4
        Transaction transaction = session.beginTransaction();
        
        //5 perform crud
//        Product p = new  Product("Laptop", 50000);
//        session.persist(p);
        
//        Product p = new  Product("Television", 100000);
//        session.save(p);  //depricated
        
        //6 
        transaction.commit();
        
        //7
        session.close();
        sf.close();
        
    }
}
