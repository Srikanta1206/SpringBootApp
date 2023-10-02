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
@EnableJpaRepositories(basePackages= "com.sri.prod.repo",
						transactionManagerRef = "txMgmt",
						entityManagerFactoryRef ="oracleEMF" )
public class OracleConfigDS {

	@Bean(name = "oracleDs")
	@ConfigurationProperties(prefix = "oracle.datasource")
	@Primary
	public DataSource createOracleDs() {
		//Here we are creating newly builded Datasource Obj
		return DataSourceBuilder.create().build();
	}
	@Bean("oracleEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		//Creating Map object having Hibernate properties
		//
		Map<String,Object> props=new HashMap<>();
		props.put("hibernate.dialect","org.hibernate.dialect.OracleDialect" );
									  
		props.put("hibernate.hbm2ddl.auto", "update");	
		
		return builder.dataSource(createOracleDs())
				.packages("com.sri.product")
				.properties(props)
				.build();
	}
	@Bean(name = "txMgmt")
	@Primary
	public PlatformTransactionManager oracleTxMgmt(@Qualifier("oracleEMF")EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
