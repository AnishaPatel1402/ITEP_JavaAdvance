package com.info.TestJPA;

import java.util.List;
import java.util.Scanner;

import com.info.TestJPA.entity.StudentCourse;
import com.info.TestJPA.entity.StudentCourseKey;
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
	           System.out.println("Press 3 for get user (Second level caching)");
	           System.out.println("Press 4 for Composite key demo of save data");
	           System.out.println("Press 5 for get data of composite key");
	           System.out.println("Press 0 for exit");
	           System.out.println("Enter your choice");
	           int choice = sc.nextInt();
	           switch(choice) {
	           case 1: insert();break;
	           case 2: login();break;
	           case 3: secondLevelCaching(); break;
	           case 4: compositeKeyDemo();
	           case 5: getStudentCourse();
	           case 0: System.exit(0);
	           }
	          }
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	    }
	 
	 
	 private static void getStudentCourse() {
		Scanner sc = new Scanner(System.in);
		 EntityManagerFactory factory = JPAUtil.getFactory();
			try(EntityManager manager = factory.createEntityManager()){
				System.out.println("enter student id: ");
				int sid = sc.nextInt();
				
				System.out.println("enter course id: ");
				int cid = sc.nextInt();
				
				StudentCourseKey key = new StudentCourseKey();
				key.setStudentId(sid);
				key.setCourseId(cid);
				
				StudentCourse stc = manager.find(StudentCourse.class, key);
				if(stc!=null)
				System.out.println(stc.getKey().getStudentId() + " " +  stc.getStudentName()+ " "+  stc.getKey().getCourseId() +" "+stc.getCourseName());
				else System.out.println("Record not found");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}


	 private static void compositeKeyDemo() {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory = JPAUtil.getFactory();
		try(EntityManager manager = factory.createEntityManager()){
			System.out.println("enter student id: ");
			int sid = sc.nextInt();
			
			System.out.println("enter course id: ");
			int cid = sc.nextInt();
			
			StudentCourseKey key = new StudentCourseKey();
			key.setStudentId(sid);
			key.setCourseId(cid);
			
			System.out.println("enter student name: ");
			String sname = sc.next();
			
			System.out.println("enter course name: ");
			String cname = sc.next();
			
			StudentCourse stc = new StudentCourse();
			stc.setStudentName(sname);
			stc.setCourseName(cname);
			stc.setKey(key);
			
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			
			manager.persist(stc);
			System.out.println("Record inserted");
			tx.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	 public static void secondLevelCaching() {
		 EntityManagerFactory factory = JPAUtil.getFactory();

		try{
			EntityManager manager = factory.createEntityManager();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the id of user: ");
			int id = sc.nextInt();
			
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			
			User u1 = manager.find(User.class, id);  //query will be fired once only | first time hit the database
			if(u1!=null)
			System.out.println(u1.getName() + " " +u1.getEmail() + " "+ u1.getAge());
			else System.out.println("No record found");
			tx.commit();
			manager.close();
			
			
			//======================================================
			
			
			
			EntityManager manager2 = factory.createEntityManager();
			EntityTransaction tx2 = manager2.getTransaction();
			tx2.begin();
			User u2 = manager2.find(User.class, id);  //this time data will come from 2nd level cache
			System.out.println(u2.getName() + " " +u2.getEmail() + " "+ u2.getAge());
			tx2.commit();
			manager2.close();
			
		} catch (Exception e) {
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
