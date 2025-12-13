package com.info.SpringXmlConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.info.SpringXmlConfig.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       Employee emp = (Employee) context.getBean("emp1");
       System.out.println(emp);
       
       emp = (Employee) context.getBean("emp2");
       System.out.println(emp);
    }
}
