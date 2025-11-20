package com.info.TestJPA;

import java.util.List;
import java.util.Scanner;

import com.info.TestJPA.entity.User;
import com.info.TestJPA.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class App 
{
	 public static void main( String[] args )
	    {
	        Scanner sc = new Scanner(System.in);
	        try {
	          while(true) { 	
	           System.out.println("Press 1 for save");
	           System.out.println("Press 2 for login");
	           System.out.println("Press 0 for exit");
	           System.out.println("Enter your choice");
	           int choice = sc.nextInt();
	           switch(choice) {
	           case 1: insert();break;
	           case 2: login();break;
	           case 0: System.exit(0);
	           }
	          }
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	    }
	 
	 
	 public static void login() {
	    	EntityManagerFactory factory  = JPAUtil.getFactory();
	    	try (EntityManager manager = factory.createEntityManager();){
	    	 Scanner sc = new Scanner(System.in);
	    	 System.out.println("Enter email id");
	    	 String emailId = sc.next();
	    	 System.out.println("Enter password");
	    	 String password = sc.next();
	    	 //jpql: java persistence query language
	    	 TypedQuery<User> query = manager.createQuery("from User where email =:email and password=:password",User.class);
	    	 query.setParameter("email", emailId);
	    	 query.setParameter("password", password);
	    	 
	    	 List<User>userList =  query.getResultList();
	    	 if(userList.size()!= 0) {
	    		 System.out.println("Login success...");
	    	 }
	    	 else
	    		 System.out.println("Invalid user (invalid email id and password)");
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static void insert() {
	       EntityManagerFactory factory = JPAUtil.getFactory(); 	
	       EntityTransaction transaction = null;
	       try (EntityManager manager = factory.createEntityManager();){
	    	   Scanner sc = new Scanner(System.in);
	    	   System.out.println("Enter name");
	    	   String name = sc.next();
	    	   System.out.println("Enter password");
	    	   String password = sc.next();
	    	   System.out.println("Enter email id");
	    	   String emailid = sc.next();
	    	   System.out.println("Enter age");
	    	   int age = sc.nextInt();
	    	   User user = new User();
	    	   user.setAge(age);
	    	   user.setEmail(emailid);
	    	   user.setName(name);
	    	   user.setPassword(password);
	    	   
	    	   transaction = manager.getTransaction();
	    	   transaction.begin();
	    	   
	    	   manager.persist(user);
	    	   transaction.commit();
	    	   System.out.println("Record saved....");
	    	   
	       }
	       catch(Exception e) {
	    	   e.printStackTrace();
	    	   if(transaction!=null && transaction.isActive())
	    		   transaction.rollback();
	       }
	    }
}
