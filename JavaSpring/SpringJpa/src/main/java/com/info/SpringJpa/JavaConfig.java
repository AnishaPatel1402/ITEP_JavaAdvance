package com.info.SpringJpa;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.info.SpringJpa.service"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.info.SpringJpa.repo"})
public class JavaConfig {
	
	@Bean
	public DriverManagerDataSource getSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jpa_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		
		factory.setPackagesToScan("com.info.SpringJpa.entity");
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(adapter);
		
		Properties prop = new Properties();
		 prop.put("hibernate.hbm2ddl.auto", "update");
		 prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		 prop.put("hibernate.show_sql", true);
		 prop.put("hibernate.format_sql", true);
		 
		 factory.setJpaProperties(prop);
		 
		 return factory;
	}
	
	@Bean(name = "transactionManager")
	public JpaTransactionManager getTransaction(LocalContainerEntityManagerFactoryBean factory) {
		JpaTransactionManager manager =  new JpaTransactionManager();
		manager.setEntityManagerFactory(factory.getObject());
		return manager;
	}
}
