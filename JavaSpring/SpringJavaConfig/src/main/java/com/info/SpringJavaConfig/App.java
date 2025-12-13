package com.info.SpringJavaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.info.SpringJavaConfig.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Employee emp = (Employee) context.getBean("getEmployee1");
        System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
        
        emp = (Employee) context.getBean("hemp");
        System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
    }
}
