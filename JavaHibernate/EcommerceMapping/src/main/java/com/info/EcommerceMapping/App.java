package com.info.EcommerceMapping;

import java.util.Scanner;

import com.info.EcommerceMapping.dao.CategoryDao;
import com.info.EcommerceMapping.dao.ProductDao;
import com.info.EcommerceMapping.dao.UserDao;
import com.info.EcommerceMapping.entity.Category;
import com.info.EcommerceMapping.entity.Product;
import com.info.EcommerceMapping.entity.User;
import com.info.EcommerceMapping.utility.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 : user registration");
        System.out.println("Press 2 : user login");
        System.out.println("Press 3 : add new category");
        System.out.println("Press 4 : add new product");
        System.out.println("Press 5 : add product to cart");
        System.out.println("Press 6 : show my cart");
        System.out.println("Press 0 : Exit");
        
        System.out.println("enter your choice: ");
        int choice = sc.nextInt();
        
        switch (choice) {
        case 0: HibernateUtil.closeSessionFactory();
        		System.exit(0);
        		
		case 1:  
			User u = new User();
			System.out.println("Enter your name: ");
			u.setName(sc.next());
			System.out.println("enter your email: ");
			u.setEmail(sc.next());
			System.out.println("enter your password: ");
			u.setPassword(sc.next());
			System.out.println("enter your aadhar no. ");
			u.setAadharno(sc.next());
			
			if(UserDao.registerUser(u)) System.out.println("User Registered");
			else System.out.println("Error!");
			break;
			
		case 2: 
			u = new User();
			System.out.println("enter your email: ");
			u.setEmail(sc.next());
			System.out.println("enter your password: ");
			u.setPassword(sc.next());
			
			if(UserDao.loginUser(u)) System.out.println("User Login Success");
			else System.out.println("Invalid user email or password!");
			break;
			
		case 3: 
			Category c = new Category();
			System.out.println("enter the category name: ");
			c.setCname(sc.next());
			
			if(CategoryDao.addCategory(c)) System.out.println("Category added");
			else System.out.println("error!");
			
			break;
			
		case 4: 
			Product p = new Product();
			System.out.println("enter product name: ");
			p.setPname(sc.next());
			System.out.println("enter product price: ");
			p.setPrice(sc.next());
			
			System.out.println("enter category id: ");
			int cid = sc.nextInt();
			
			c = CategoryDao.findById(cid);
			if(c!=null) {
				p.setProductCategory(c);
				if(ProductDao.addProduct(p))System.out.println("product added");
				else System.out.println("error!");
			}
			else System.out.println("Category not found");
			break;

		default: System.out.println("Invalid Choice");
		}
    }
}
