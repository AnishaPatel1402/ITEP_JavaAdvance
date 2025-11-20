package com.info.EcommerceMapping.utility;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHashUtil {
	public static String hashPassword(String plainPassword) {
		String hashedPassword =  BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
		return hashedPassword;
	}
	
	public static boolean checkPassword(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}
}
