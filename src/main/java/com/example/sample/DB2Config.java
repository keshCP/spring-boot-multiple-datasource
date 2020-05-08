package com.example.sample;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db2EntityManagerFactory",
    transactionManagerRef = "db2TransactionManager", basePackages = {"com.example.sample.dao.db2"})
public class DB2Config {

	
	  //DB2 is secondary data source and it use jpa.
	
	  @Bean(name = "dsDB2")
	  @ConfigurationProperties(prefix = "spring.second-db")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }

	  @Bean(name = "db2EntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("dsDB2") DataSource dataSource) {
	    return builder.dataSource(dataSource).packages("com.example.sample.entity.db2").persistenceUnit("DB2")
	        .build();
	  }

	  @Bean(name = "db2TransactionManager")
	  public PlatformTransactionManager db2TransactionManager(
	      @Qualifier("db2EntityManagerFactory") EntityManagerFactory db2EntityManagerFactory) {
	    return new JpaTransactionManager(db2EntityManagerFactory);
	  }
}
