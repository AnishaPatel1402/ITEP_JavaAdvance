package com.StudentHQL.StudentHQL;

import java.util.Scanner;

import com.StudentHQL.StudentHQL.dao.StudentDAO;

public class App {
	public static void main(String[] args) {
		try {

			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n\nWelcome To Student CRUD App");
				System.out.println("++++++++++ Menu ++++++++++");
				System.out.println(
						"Press 1 : Register Student \nPress 2 : Get All Student \nPress 3 : Update Student details \nPress 4 : Delete Student  \nPress 5 : Authenticate Student \nPress 0 : Exit");
				System.out.print("Enter Your Choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 0: // exit
					System.exit(0);
					break;
				case 1: // register
					StudentDAO.resgisterStudent();
					break;

				case 2: // Get student
					StudentDAO.getAllStudents();
					break;

				case 3: // Update student
					StudentDAO.UpdateStudent();
					break;
					
				case 4:  //Delete student
					StudentDAO.deleteStudent();
					break;
					
				case 5:  //authenticate student
					StudentDAO.authenticateStudent();
					break; 

				default:
					System.out.println("Invalid Choice");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
