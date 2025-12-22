package com.info.optimizedSpringJdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.info.optimizedSpringJdbc.entity.Student;
import com.info.optimizedSpringJdbc.service.StudentService;

public class App 
{
    public static void main( String[] args )
    {
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
			try {
				ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
				StudentService service = context.getBean(StudentService.class);
				
				Student student = new Student();
				student.setRoll(1111);
				student.setName("demo Patel");
				student.setCourse("PythonFullStack");
				
				if(service.save(student)) System.out.println("Student saved");
				else System.out.println("Student not saved");
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		case 2:
			try {
				ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
				StudentService service = context.getBean(StudentService.class);
				
				Student student = new Student();
				student.setRoll(1010);
				student.setName("Anisha Patel");
				student.setCourse("Java Full Stack");
				
				if(service.update(student)) System.out.println("Student updated");
				else System.out.println("Student not updated");
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case 3:
			try {
				ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
				StudentService service = context.getBean(StudentService.class);
				
				int roll = 1111;
				
				
				if(service.delete(roll)) System.out.println("Student deleted");
				else System.out.println("Student not deleted");
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case 4:
			try {
				ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
				StudentService service = context.getBean(StudentService.class);
				List< Student> list = service.getAll();
				
				if(list.size() > 0) {
					for(Student s : list) {
						System.out.println(s.getRoll()+" "+s.getName()+" "+ s.getCourse());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		
		case 5:
			try {
				ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
				StudentService service = context.getBean(StudentService.class);
				Student s = service.get(1010);
				if(s!=null) System.out.println(s.getRoll()+" "+s.getName()+" "+ s.getCourse());
				else System.out.println("Not found");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
    }
}
