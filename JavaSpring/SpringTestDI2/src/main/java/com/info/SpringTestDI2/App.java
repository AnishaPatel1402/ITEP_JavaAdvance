package com.info.SpringTestDI2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.info.SpringTestDI2.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee e = (Employee) context.getBean("emp1");
        e.display();
    }
}
