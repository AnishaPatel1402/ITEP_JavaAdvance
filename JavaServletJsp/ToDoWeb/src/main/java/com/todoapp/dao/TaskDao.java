package com.todoapp.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.todoapp.entity.Category;
import com.todoapp.entity.Task;
import com.todoapp.utility.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class TaskDao {
	public static boolean addTask(Task task) {
		EntityManagerFactory factory = JPAUtil.getFactory();
		EntityTransaction tx = null;
		try (EntityManager manager = factory.createEntityManager()) {
			tx = manager.getTransaction();
			tx.begin();

			long date = System.currentTimeMillis();
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			String createdDate = sd.format(new Date(date));
			
			task.setCreatedDate(createdDate);
			
			Category category = manager.find(Category.class, task.getCategoryId());
			task.setCategory(category);
			
			task.setStatus("Pending");

			manager.persist(task);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	public static List<Task> getTaskList() {
		EntityManagerFactory factory = JPAUtil.getFactory();

		try (EntityManager manager = factory.createEntityManager()) {

			TypedQuery<Task> query = manager.createQuery("from Task", Task.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	public static Task getTaskById(Task task) {
		EntityManagerFactory factory = JPAUtil.getFactory();

		try (EntityManager manager = factory.createEntityManager()) {
			Task t = manager.find(Task.class, task.getId());
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static boolean deleteTask(Task task) {
		EntityManagerFactory factory = JPAUtil.getFactory();
		EntityTransaction tx = null;
		try (EntityManager manager = factory.createEntityManager()){
			tx = manager.getTransaction();
			tx.begin();
			Task t = manager.find(Task.class, task.getId());
			if(t != null) {
				manager.remove(t);
				tx.commit();
				return true;
			} else return false;
			
			
		} catch (Exception e) {
			if(tx!=null && tx.isActive()) tx.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}
