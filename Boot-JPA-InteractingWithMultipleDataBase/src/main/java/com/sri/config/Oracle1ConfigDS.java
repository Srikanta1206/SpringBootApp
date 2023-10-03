package com.sri.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages= "com.sri.user.repo",
						transactionManagerRef = "txMgmt1",
						entityManagerFactoryRef ="oracle1EMF" )
public class Oracle1ConfigDS {

	@Bean(name = "oracle1Ds")
	@ConfigurationProperties(prefix = "oracle1.datasource")
	public DataSource createOracleDs() {
		//Here we are creating newly builded Datasource Obj
		return DataSourceBuilder.create().build();
	}
	@Bean("oracle1EMF")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		//Creating Map object having Hibernate properties
		//
		Map<String,Object> props=new HashMap<>();
		props.put("hibernate.dialect","org.hibernate.dialect.OracleDialect" );
									  
		props.put("hibernate.hbm2ddl.auto", "update");	
		
		return builder.dataSource(createOracleDs())
				.packages("com.sri.user")
				.properties(props)
				.build();
	}
	@Bean(name = "txMgmt1")
	public PlatformTransactionManager oracleTxMgmt(@Qualifier("oracle1EMF")EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
