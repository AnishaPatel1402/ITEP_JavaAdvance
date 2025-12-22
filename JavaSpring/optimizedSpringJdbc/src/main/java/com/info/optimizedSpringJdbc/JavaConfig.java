package com.info.optimizedSpringJdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.info.optimizedSpringJdbc.dao.StudentDao;

@Configuration
@ComponentScan(basePackages = {"com.info.optimizedSpringJdbc.service"})
@EnableTransactionManagement
public class JavaConfig {
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	public JdbcTemplate getTemplate(DataSource dataSource) {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource); 
		return template;
	}
	
	
	@Bean
	public StudentDao getDao(JdbcTemplate template){
		return new StudentDao(template);
	}
	
	@Bean
	public PlatformTransactionManager getTransaction(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
