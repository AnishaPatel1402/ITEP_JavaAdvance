package com.info.SpringTestDI2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.info.SpringTestDI2.entity.Customer;
import com.info.SpringTestDI2.entity.Nominee;

public class App2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer c = (Customer) context.getBean("cust1");
		Nominee n = c.getNominee();
		System.out.println("Customer details: " + c.getId() + " " + c.getName() + " " + c.getAge());
		System.out.println("Nominee details: "+ n.getName() + " " + n.getContact());
	}

}
