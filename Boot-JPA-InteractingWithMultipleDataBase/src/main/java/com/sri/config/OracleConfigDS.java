package com.sri.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class OracleConfigDS {

	@Bean(name = "oracleDs")
	public DataSource createOracleDs() {
		//Here we are creating newly builded Datasource Obj
		return DataSourceBuilder.create().build();
	}
	@Bean("oracleContainer")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		//Creaaring Map object having Hibernate properties
		
		Map<String,Object> props=new HashMap<>();
		props.put("hibernate.dialect","org.hibernate.dialect,Oracle10gDialect" );
		props.put("hibernate.hbm2ddl.auto", "update");
		
		
				
		
		
	}
	@Bean(name = "txMgmt")
	@Primary
	public PlatformTransactionManager oracleTxMgmt(@Qualifier("oracleEMF")EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
