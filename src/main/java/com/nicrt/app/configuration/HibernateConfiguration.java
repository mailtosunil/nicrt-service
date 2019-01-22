/*package com.nicrt.app.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

*//**
 * @author SunilKumar Designed for configuration related information
 *//*
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "application.properties" })
public class HibernateConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.nicrt.app.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
		return dataSource;
	}

	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect",
				environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.show-sql"));
		properties.setProperty("hibernate.format_sql",
				environment.getRequiredProperty("spring.jpa.properties.hibernate.format_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto",
				environment.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		return properties;
	}

	
	 * @Bean
	 * 
	 * @Autowired public HibernateTransactionManager
	 * transactionManager(SessionFactory factory) { HibernateTransactionManager
	 * transactionManager = new HibernateTransactionManager();
	 * transactionManager.setSessionFactory(factory); return transactionManager; }
	 
}
*/