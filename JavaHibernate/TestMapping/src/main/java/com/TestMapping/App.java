package com.TestMapping;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.TestMapping.entity.Category;
import com.TestMapping.entity.Course;
import com.TestMapping.entity.Passport;
import com.TestMapping.entity.Product;
import com.TestMapping.entity.Student;
import com.TestMapping.entity.User;
import com.TestMapping.utility.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Press 1 : Add user");
			System.out.println("Press 2 : fetch user and passport details");
			System.out.println("Press 3 : insert Category");
			System.out.println("Press 4 : insert product into category");
			System.out.println("Press 5 : see product and category");
			System.out.println("Press 6 : To insert Student and courses");
			System.out.println("Press 0 : exit");
			System.out.println("enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				insertUser();
				break;
			case 2:
				fetchDetails();
				break;
			case 3:
				insertCategory();
				break;
				
			case 4:
				insertProduct();
				break;
			case 5: 
				fetchProductAndCategory();
				break;
			case 6: 
				addStudent();
				break;
			case 0:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
	
	
	public static void addStudent() {
		SessionFactory sf = HibernateUtil.getFactory();
		try(Session session = sf.openSession()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the course 1 name: ");
			String cname1 = sc.next();
			Course c1 = new Course();
			c1.setCname(cname1);
			
			System.out.println("enter the course 2 name: ");
			String cname2 = sc.next();
			Course c2 = new Course();
			c2.setCname(cname2);
			
			System.out.println("enter the student name: ");
			String sname = sc.next();
			Student s1 = new Student();
			
			s1.setSname(sname);
			
			
			// Add courses to student
			s1.getCourses().add(c1);
			s1.getCourses().add(c2);

			// VERY IMPORTANT — Add student to each course
			c1.getStudentList().add(s1);
			c2.getStudentList().add(s1);
			
			Transaction tx = session.beginTransaction();
			session.persist(s1);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fetchProductAndCategory() {
		SessionFactory sf = HibernateUtil.getFactory();
		try (Session session = sf.openSession()){
			
			Scanner sc = new Scanner(System.in);
			System.out.println("what you want product or category (enter p : product | c : for category)");
			char ch = sc.next().charAt(0);
			//to by fetch category 
			if(ch=='c') {
				System.out.println("enter the category id: ");
				int id = sc.nextInt();
				
				Category c = session.get(Category.class, id);  //by default it will fetch in lazily but if we want it to fetch eager then we have to mention the fetch type
				if(c!=null) {
					List<Product> productList = c.getProducts();
					System.out.println(c.getCname());
					for(Product p : productList) {
						System.out.println(p.getPid() + " "+ p.getTitle() + " " + p.getPrice());
					}
				}
			}
			//to fetch product 
			else if(ch == 'p') {
				System.out.println("enter the product id: ");
				int id = sc.nextInt();
				Product p = session.get(Product.class, id);
				if(p!=null) {
					System.out.println(p.getPid() + " " + p.getTitle() + " "+ p.getPrice() + " "+ p.getCategory().getCid() + " "+ p.getCategory().getCname());
				}else System.out.println("Product not found");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void insertCategory() {
		SessionFactory sf = HibernateUtil.getFactory();
		try (Session session = sf.openSession()){
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the category: ");
			String category = sc.next();
			
			Category c = new Category();
			c.setCname(category);
			
			Transaction tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			System.out.println("Category added");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void insertProduct() {
		SessionFactory sf = HibernateUtil.getFactory();
		try (Session session = sf.openSession()){
			Scanner sc = new Scanner(System.in);
			
			System.out.println("enter the category id: ");
			int cid = sc.nextInt();
			Category c = session.get(Category.class, cid);
			if(c != null) {
				System.out.println("enter product name: ");
				String pname = sc.next();
				System.out.println("enter product price: ");
				int price = sc.nextInt();
				
				Product p = new Product();
				p.setTitle(pname);
				p.setPrice(price);
				p.setCategory(c);
				
				Transaction tx = session.beginTransaction();
				session.persist(p);
				tx.commit();
				System.out.println("product added");
			}
			else System.out.println("Category not found");
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fetchDetails() {
		SessionFactory sf = HibernateUtil.getFactory();
		try (Session session = sf.openSession()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the id of user you want to fetch: ");
			int id = sc.nextInt();
			
//			getting passport details by user 
//			User u = session.get(User.class, id);
//			if (u != null)
//				System.out.println(u.getId() + " " + u.getName() + " " + u.getPassport().getPassportNum());
//			else
//				System.out.println("User not found");
			
			
//			get the user details by passport
			
			TypedQuery<Passport> query = session.createQuery("from Passport where user.id=:uid", Passport.class);
			query.setParameter("uid", id);
			Passport p = query.getSingleResult();
			
			User u = p.getUser();
			
			System.out.println(u.getId() + " " + u.getName() + " "+ p.getPassportNum());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void insertUser() {
		SessionFactory sf = HibernateUtil.getFactory();
		try (Session session = sf.openSession()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the User name: ");
			String uname = sc.next();

			Transaction tx = session.beginTransaction();

			User user1 = new User(uname);

			Passport passport1 = new Passport();
			System.out.println("enter the passport number: ");
			String pnum = sc.next();
			passport1.setPassportNum(pnum);

			user1.setPassport(passport1);
			passport1.setUser(user1);

			session.persist(user1);
//    		session.persist(passport1);  //we add cascade so passport will automatically saved when user get saved
			System.out.println("user added");
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}