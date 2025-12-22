package com.info.SpringJdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.info.SpringJdbc.dao.UserDao;
import com.info.SpringJdbc.entity.User;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu");
		System.out.println("Press 1 for save user");
		System.out.println("Press 2 for update user");
		System.out.println("Press 3 for delete user");
		System.out.println("Press 4 for get all user");
		System.out.println("Press 5 for get user by id");
		System.out.println("Press 0 for exit");
		int choice = sc.nextInt();

		switch (choice) {
		case 0:
			System.exit(0);
			break;
		case 1:
			save();
			break;

		case 2:
			update();
			break;
			
		case 3:
			delete();
			break;
			
		case 4:
			getUsers();
			break;
		
		case 5:
			getUserById();
			break;

		default:
			break;
		}
	}

	public static void save() {
		try {
			Scanner sc = new Scanner(System.in);
			User user = new User();
			System.out.println("enter the user id: ");
			user.setId(sc.nextInt());
			System.out.println("enter the user name: ");
			user.setName(sc.next());
			System.out.println("enter the user age: ");
			user.setAge(sc.nextInt());

			ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
			UserDao dao = context.getBean(UserDao.class);
			if (dao.saveUser(user))
				System.out.println("user saved");
			else
				System.out.println("user not saved");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void update() {
		try {
			Scanner sc = new Scanner(System.in);
			User user = new User();
			System.out.println("enter the user id: ");
			user.setId(sc.nextInt());
			System.out.println("enter the user name: ");
			user.setName(sc.next());
			System.out.println("enter the user age: ");
			user.setAge(sc.nextInt());

			ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
			UserDao dao = context.getBean(UserDao.class);
			if (dao.updateUser(user))
				System.out.println("user updated");
			else
				System.out.println("user not updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void delete() {
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("enter the user id: ");
			int id = sc.nextInt();

			ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
			UserDao dao = context.getBean(UserDao.class);
			if (dao.deleteUser(id))
				System.out.println("user deleted");
			else
				System.out.println("user not deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getUserById() {
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("enter the user id: ");
			int id = sc.nextInt();

			ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
			UserDao dao = context.getBean(UserDao.class);
			
			User u = dao.getUser(id);
			System.out.println(u.getId()+"  "+u.getName()+"  "+u.getAge());
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getUsers() {
		try {

			ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
			UserDao dao = context.getBean(UserDao.class);
			 List<User> list = dao.getList();
	    	    for(User u : list)
	    	    	System.out.println(u.getId()+"  "+u.getName()+"  "+u.getAge());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
