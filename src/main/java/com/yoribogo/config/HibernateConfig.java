package com.yoribogo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration/*설정을 가지고 있는 놈이다*/
@EnableTransactionManagement/*트랜잭션매니저*/
@ComponentScans(value= {
		@ComponentScan("com.yoribogo.service"),
		@ComponentScan("com.yoribogo.dao.hb")
})
public class HibernateConfig {
	
	
	
	
	
	@Bean(destroyMethod="close") //데이터 소스가 콩보따리에 들어간다.
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://211.58.161.171:3306/yoribogodb?serverTimezone=UTC&autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8");
		dataSource.setUser("min");
		dataSource.setPassword("minmin");
		
		/*쿨링 관련*/
		dataSource.setMinPoolSize(5);
		dataSource.setMaxPoolSize(20);
		dataSource.setMaxIdleTime(3000);
		
		
		return dataSource;
		
	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException { /*하이버네이트 설정*/
		
		Properties pros = new Properties();
		pros.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		pros.put("hibernate.show_sql", "true");
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.yoribogo.entity");
		sessionFactory.setHibernateProperties(pros);
		
		
		return sessionFactory;
		
	}
	
	
	@Bean//트랜잭션 처리
	public HibernateTransactionManager transactionManager() throws PropertyVetoException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
		
	}

	
}
