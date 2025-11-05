package com.app;

import com.dao.UserDao;
import com.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        User u1 = new User("Anisha Patel", "Bhopal", "a123");
        boolean status = UserDao.addUser(u1);
        if(status) System.out.println("User added!");
        else System.out.println("User not added!");
    }
}
