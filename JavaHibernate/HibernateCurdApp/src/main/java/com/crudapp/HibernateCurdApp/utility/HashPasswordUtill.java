package com.crudapp.HibernateCurdApp.utility;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class HashPasswordUtill {
	
	//plain password -> Hash password
	public static String hashPassword(String plainPassword) {
		 String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
		 System.out.println("Password after hashing : " + hashedPassword);
		 return hashedPassword;
	}
	
	//Hash password -> plain password
	public static boolean checkPassword(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}
	
}
