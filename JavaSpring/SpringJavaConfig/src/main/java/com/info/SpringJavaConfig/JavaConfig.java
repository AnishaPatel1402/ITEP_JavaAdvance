package com.info.SpringJavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.info.SpringJavaConfig.entity.Employee;

@Configuration
public class JavaConfig {
	
	@Bean
	public Employee getEmployee1() {
		Employee e = new Employee();
		e.setId(110);
		e.setName("Khushi Sahu");
		e.setSalary(70000);
		
		return e;
	}
	
	@Bean(name="hemp")
	public Employee getEmployee2() {
		Employee e = new Employee();
		e.setId(111);
		e.setName("Harshit Kumbhkar");
		e.setSalary(90000);
		
		return e;
	}
	
}
