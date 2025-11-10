package com.StudentHQL.StudentHQL.dao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.StudentHQL.StudentHQL.entity.StudentEntity;
import com.StudentHQL.StudentHQL.utility.HibernateHqlUtility;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class StudentDAO {

	public static void resgisterStudent() {
		SessionFactory sf = HibernateHqlUtility.getSessionFactory();
		Transaction transaction = null;
		try(Session session = sf.openSession()) {
			
			Scanner sc = new Scanner(System.in);
	    	System.out.println("Enter name");
	    	String name = sc.next();
	    	System.out.println("Enter email id");
	    	String emailId = sc.next();
	    	
	    	Date date = new Date();
	    	
	    	transaction = session.beginTransaction();
	    	StudentEntity s = new StudentEntity(name, emailId, date);
	    	
	    	session.persist(s);
	    	transaction.commit();
	    	System.out.println("\nStudent registered");
	    	
			
		}catch(Exception e) {
			if (transaction != null && transaction.isActive())
				transaction.rollback();
			e.printStackTrace();
		}
		
	}

	public static void getAllStudents() {
		SessionFactory sf = HibernateHqlUtility.getSessionFactory();
		
		try(Session session = sf.openSession()) {
	    	TypedQuery<StudentEntity> query = session.createQuery("from StudentEntity", StudentEntity.class);
	    	
	    	List<StudentEntity> students = query.getResultList();
	    	
	    	for(StudentEntity s : students) {
	    		System.out.println("Roll Number : "+ s.getRollno());
	    		System.out.println("Name : "+ s.getName());
	    		System.out.println("Email : "+ s.getEmail());
	    		System.out.println("Date of Addmission : "+ s.getDate());
	    		System.out.println();
	    	}
	    	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void UpdateStudent() {
		SessionFactory sf = HibernateHqlUtility.getSessionFactory();
		Transaction transaction = null;
		try(Session session = sf.openSession()) {
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Roll number of student for updation: ");
			int roll = sc.nextInt();	
			
			TypedQuery<StudentEntity> query1 = session.createQuery("from StudentEntity where rollno=:rollno", StudentEntity.class);
			query1.setParameter("rollno", roll);
		
			StudentEntity s = query1.getSingleResult();
			
			transaction = session.beginTransaction();
			
			System.out.println("Current value: " + s.getName() + " Enter name");
	    	String name = sc.next();
	    	System.out.println("Current value: " + s.getEmail() + " Enter email id");
	    	String emailId = sc.next();
	    	
	    	Query query = session.createQuery("UPDATE StudentEntity SET name=:name, email=:email WHERE rollno=:rollno");
	    	query.setParameter("name", name);
	    	query.setParameter("email", emailId);
	    	query.setParameter("rollno", roll);
	    	int x = query.executeUpdate();
	    	
	    	if(x != 0)	System.out.println("\nStudent Updated");
	    	else System.out.println("Error in  Update");
	    	transaction.commit();
			
		}catch(Exception e) {
			if (transaction != null && transaction.isActive())
				transaction.rollback();
			e.printStackTrace();
		}
		
	}

	public static void deleteStudent() {
		SessionFactory sf = HibernateHqlUtility.getSessionFactory();
		Transaction transaction = null;
		try(Session session = sf.openSession()) {
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Roll number of student for deletion: ");
			int roll = sc.nextInt();	
			
			transaction = session.beginTransaction();
	    	
	    	TypedQuery<StudentEntity> query = session.createQuery("DELETE StudentEntity WHERE rollno=:rollno");
	    	query.setParameter("rollno", roll);
	    	int x = query.executeUpdate();
	    	
	    	if(x != 0)	System.out.println("\nStudent Deleted");
	    	else System.out.println("Error in  delete");
	    	transaction.commit();
			
		}catch(Exception e) {
			if (transaction != null && transaction.isActive())
				transaction.rollback();
			e.printStackTrace();
		}
	}

	public static void authenticateStudent() {
		SessionFactory sf = HibernateHqlUtility.getSessionFactory();
		
		try(Session session = sf.openSession()) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your email: ");
			String email = sc.next();
			
			System.out.println("enter you name: ");
			String name = sc.next();
			
			TypedQuery<StudentEntity> query = session.createQuery("from StudentEntity where name=:name and email=:email",StudentEntity.class);
			query.setParameter("name", name);
			query.setParameter("email", email);
			
			StudentEntity s = query.getSingleResult();
			
			System.out.println("\nWelcome "+ s.getName() + ", Login Successfull");
			
			
		}catch(NoResultException e) {
			System.out.println("\nInvalid username or email");
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
