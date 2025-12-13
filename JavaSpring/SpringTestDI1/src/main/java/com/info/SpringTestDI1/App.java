package com.info.SpringTestDI1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.info.SpringTestDI1.entity.Customer;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       Customer c =(Customer)  context.getBean("customer1");
       System.out.println(c.getId() + " "+ c.getName() + " "+ c.getAge());
       
       c =(Customer)  context.getBean("customer2");
       System.out.println(c.getId() + " "+ c.getName() + " "+ c.getAge());
       
       c =(Customer)  context.getBean("customer3");
       System.out.println(c.getId() + " "+ c.getName() + " "+ c.getAge());
    }
}
