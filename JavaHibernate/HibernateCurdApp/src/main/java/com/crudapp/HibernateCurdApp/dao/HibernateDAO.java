package com.crudapp.HibernateCurdApp.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.crudapp.HibernateCurdApp.entity.Student;
import com.crudapp.HibernateCurdApp.utility.HashPasswordUtill;
import com.crudapp.HibernateCurdApp.utility.HibernateUtil;

public class HibernateDAO {
	public static void resgisterStudent() {
		try(SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();){
			
			Scanner sc = new Scanner(System.in);
	    	System.out.println("Enter name");
	    	String name = sc.next();
	    	System.out.println("Enter email id");
	    	String emailId = sc.next();
	    	System.out.println("Enter password");
	    	String password = sc.next();
	    	
	    	
	    	
	    	Student s = new Student(name, emailId, password);
	    	Transaction transaction = session.beginTransaction();
	    	session.persist(s);
	    	transaction.commit();
	    	System.out.println("Student Registration Successfull");
	    	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getStudentByRollNo() {
		try(SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();){
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Roll number of student: ");
			int roll = sc.nextInt();
			
			Student s = session.get(Student.class, roll);
			
			System.out.printf("\n\n Student Name : %s\n Roll NO : %d\n Email Id : %s\n", s.getName(), s.getRollno(), s.getEmail());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void UpdateStudent() {  //get -> update -> persist
		
		try(SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();){
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Roll number of student for updation: ");
			int roll = sc.nextInt();
			
			
			Transaction tx = session.beginTransaction();
			
			//get the student first 
			Student s = session.get(Student.class, roll);
			
			
			if(s != null) {  // if student found
				System.out.println("Current value:  "+ s.getName() +"  Enter name");
		    	String name = sc.next();
		    	System.out.println("Current value:  "+ s.getEmail() +"  Enter email id");
		    	String emailId = sc.next();
		    	System.out.println("Current value:  "+ s.getPassword() +"  Enter password");
		    	String password = sc.next();
		    	
		    	//update the student now
		    	s.setName(name);
		    	s.setEmail(emailId);
		    	s.setPassword(password);
		    	
		    	//now save student
//		    	session.persist(s);  //here we don't need to call persist because our object is in persist state so it will affect in database as well 
		    	
		    	tx.commit();
		    	
		    	System.out.println("\nStudent Updated Successfull");
		    	
			} 
			else if(s==null) {
				System.out.println("Student not found");
				return;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteStudent() {  //get -> delete(remove)
		try(SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();){
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the Roll number of student for deletion: ");
				int roll = sc.nextInt();
				
				
				Transaction tx = session.beginTransaction();
				
				//get the student first 
				Student s = session.get(Student.class, roll);
				
				
				//now delete student 
			    if(s!=null) {
			    	session.remove(s);
			    	tx.commit();
			    	System.out.println("\nStudent Deleted Successfull");
			    	
				} 
				else if(s==null){
					System.out.println("Student not found");
					return;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	public static void authenticateStudent() {
		try(SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();){
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("enter your Id: ");
			int id = sc.nextInt();
			System.out.println("Enter your password : ");
			String plainPassword = sc.next();
			
			Student s = session.get(Student.class, id);
			if(s == null) {
				System.out.println("Student not found!");
				return;
			}
			
			boolean isValidStudent = HashPasswordUtill.checkPassword(plainPassword, s.getPassword());
			System.out.println("\n\nuser password = " + plainPassword);
			System.out.println("Hashed password = " + s.getPassword());
			
			if(isValidStudent) System.out.println("You authentication succesfull");
			else System.out.println("Invalid student");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
