package com.todoapp.dao;

import java.util.List;

import com.todoapp.entity.Category;
import com.todoapp.utility.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class CategoryDao {
	public static boolean addCategory(Category category) {
		EntityManagerFactory factory = JPAUtil.getFactory();
		EntityTransaction tx = null;
		try (EntityManager manager = factory.createEntityManager()){
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(category);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			if(tx!=null && tx.isActive()) tx.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static List<Category> getCategoryList(){
		EntityManagerFactory factory = JPAUtil.getFactory();
		
		try (EntityManager manager = factory.createEntityManager()){
			TypedQuery<Category> query = manager.createQuery("from Category", Category.class);
			return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static boolean deleteCategory(Category c) {
		EntityManagerFactory factory = JPAUtil.getFactory();
		EntityTransaction tx = null;
		try (EntityManager manager = factory.createEntityManager()){
			tx = manager.getTransaction();
			tx.begin();
			Category category = manager.find(Category.class, c.getId());
			if(category != null) {
				manager.remove(category);
				tx.commit();
				return true;
			} else return false;
			
			
		} catch (Exception e) {
			if(tx!=null && tx.isActive()) tx.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static Category fetchCategoryById(Category c) {
		EntityManagerFactory factory = JPAUtil.getFactory();
		EntityTransaction tx = null;
		try (EntityManager manager = factory.createEntityManager()){
			tx = manager.getTransaction();
			tx.begin();
			Category category = manager.find(Category.class, c.getId());
			if(category != null) {
				return category;
			}
			return null;
			
		} catch (Exception e) {
			if(tx!=null && tx.isActive()) tx.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		
		}
	}
	
	
	public static boolean updateCategory(Category c) { //load -> update -> persist
		EntityManagerFactory factory = JPAUtil.getFactory();
		EntityTransaction tx = null;
		try (EntityManager manager = factory.createEntityManager()){
			tx = manager.getTransaction();
			tx.begin();
			//load
			Category cat = manager.find(Category.class, c.getId());
			//update 
			cat.setTaskCategory(c.getTaskCategory());
			//persist
			manager.persist(cat);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			if(tx!=null && tx.isActive()) tx.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}
