package com.sri.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class OracleConfigDS {

	@Bean(name = "oracleDs")
	public DataSource createOracleDs() {
		//Here we are creating newly builded Datasource Obj
		return DataSourceBuilder.create().build();
	}
	
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		//Crearing Map object having Hibernate properties
		
		Map<String,Object> props=new HashMap<>();
		props.put("hibernate.dialect","org.hibernate.dialect,Oracle10gDialect" );
		props.put("hibernate.hbm2ddl.auto", "update");
	}
}
