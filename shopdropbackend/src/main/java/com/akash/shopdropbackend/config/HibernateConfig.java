package com.akash.shopdropbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.akash.shopdropbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

//	Change these values touse a different database
	private static final String DATABASE_URL = "jdbc:mysql://localhost/shopdrop";
	private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "root";

//	Adding conn info to the DataSource
	@Bean
	public DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(DATABASE_URL);
		ds.setDriverClassName(DATABASE_DRIVER);
		ds.setUsername(DATABASE_USERNAME);
		ds.setPassword(DATABASE_PASSWORD);

		return ds;
	}

//	Session Factory Bean Will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource ds) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);

//		Adding the properties
		builder.addProperties(getHibernateProperties());

//		Scanning Entity classes
		builder.scanPackages("com.akash.shopdropbackend.dto");

		return builder.buildSessionFactory();

	}

//	This method will return the hibernate properties set in the method
	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true"); // "true" in strings
		properties.put("hibernate.format_sql", "true"); // "true" in strings

		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

}
