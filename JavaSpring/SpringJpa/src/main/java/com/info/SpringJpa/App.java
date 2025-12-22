package com.info.SpringJpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.info.SpringJpa.entity.User;
import com.info.SpringJpa.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User u = new User();
        u.setEmail("user@gmail.com");
        u.setPassword("12345");
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService service = context.getBean(UserService.class);
        
        if(service.saveUser(u)) System.out.println("user saved");
        else System.out.println("user not saved  ");
    }
}
