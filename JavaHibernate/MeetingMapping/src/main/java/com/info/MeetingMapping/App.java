package com.info.MeetingMapping;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.info.MeetingMapping.entity.AadharCard;
import com.info.MeetingMapping.entity.Actor;
import com.info.MeetingMapping.entity.Movies;
import com.info.MeetingMapping.entity.Person;
import com.info.MeetingMapping.entity.Student;
import com.info.MeetingMapping.entity.Teacher;
import com.info.MeetingMapping.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Press 1 : for save person");
			System.out.println("Press 2 : for get person");
			System.out.println("Press 3 : for get aadhar");
			System.out.println("Press 4 : for save Teacher");
			System.out.println("Press 5 : for get student");
			
			System.out.println("Press 6 : for save Movies");
			
			System.out.println("Press 0 : for exit");

			System.out.println("enter your choice: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				insert();
				break;
			case 2:
				getPerson();
				break;
			case 3:
				getAadhar();
				break;
				
			case 4: saveTeacher(); break;
			
			case 5: getStudent(); break;
			
			case 6: saveMovie();

			case 0:
				System.exit(0);

			default:
				break;
			}
		}
	}

	private static void saveMovie() {
		SessionFactory sf = HibernateUtil.getFactory();
		Transaction tx = null;
		try (Session session = sf.openSession()) {

			tx = session.beginTransaction();
			
			Movies m1 = new Movies();
			m1.setMname("Ghajni");
			
			Actor a1 = new Actor();
			a1.setAname("Jonney lever");
			
			
			Actor a2 = new Actor();
			a2.setAname("Sunil Grover");
			
		
			Actor a3 = new Actor();
			a3.setAname("Madhuri");
			
			m1.getActorsList().add(a1);
			m1.getActorsList().add(a2);
			m1.getActorsList().add(a3);
			
			session.persist(m1);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getStudent() {
		SessionFactory sf = HibernateUtil.getFactory();

		try (Session session = sf.openSession()) {

			int id = 6;

			Student std = session.get(Student.class, id);
			
			System.out.println("Student name: "+ std.getSname());
			
			Teacher stdTeacher = std.getTeacher();
			
			System.out.println("Teacher = "+ stdTeacher.getTname());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void saveTeacher() {
		
		SessionFactory sf = HibernateUtil.getFactory();
		Transaction tx = null;
		try (Session session = sf.openSession()) {

			tx = session.beginTransaction();
			
			Teacher teacher = new Teacher();
			teacher.setTname("Pawan sir");
			
			
			Student s1 = new Student();
			s1.setSname("anisha");
			s1.setTeacher(teacher);
			
			Student s2 = new Student();
			s2.setSname("neha");
			s2.setTeacher(teacher);
			
			Student s3 = new Student();
			s3.setSname("shivam");
			s3.setTeacher(teacher);
			
			
			//students added to teacher
			teacher.getStudentList().add(s1);
			teacher.getStudentList().add(s2);
			teacher.getStudentList().add(s3);
			
			session.persist(teacher);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void getAadhar() {
		SessionFactory sf = HibernateUtil.getFactory();

		try (Session session = sf.openSession()) {

			int id = 3;

			AadharCard a = session.get(AadharCard.class, id);
			
			System.out.println(a.getPerson().getName() + " "+  a.getPerson().getAge() + " "+ a.getAadharno());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void getPerson() {
		SessionFactory sf = HibernateUtil.getFactory();

		try (Session session = sf.openSession()) {

			int id = 1;

			Person person = session.get(Person.class, id);
			System.out.println(person.getName() + " " + person.getPersonAadhar().getAadharno());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void insert() {
		SessionFactory sf = HibernateUtil.getFactory();
		Transaction tx = null;
		try (Session session = sf.openSession()) {

			Person p = new Person();
			p.setName("Devraj");
			p.setAge(22);

			AadharCard a = new AadharCard();
			a.setAadharno("devraj1234");

			// person link to aadhar
			p.setPersonAadhar(a);

			// aadhar link to link
			a.setPerson(p);

			tx = session.beginTransaction();

			session.persist(p);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
