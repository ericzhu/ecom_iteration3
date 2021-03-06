package com.ecomlogix.ecom.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY)
@PropertySource({ "classpath:META-INF/persistence.properties" })
public class DataConfiguration {

   public static final String PERSISTENCE_UNIT_NAME = "ecom";

   @Inject
   Environment                environment;

   @Bean
   public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setUsername(environment.getProperty("db.username"));
      dataSource.setPassword(environment.getProperty("db.password"));
      dataSource.setUrl(environment.getProperty("db.url"));
      return dataSource;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
      factory.setDataSource(dataSource());
      factory.setJpaVendorAdapter(jpaVendorAdapter());
      factory.setJpaProperties(jpaProperties());
      factory.setPackagesToScan("com.ecomlogix.ecom.domain");
      return factory;
   }

   @Bean
   public PlatformTransactionManager transactionManager() {
      JpaTransactionManager txManager = new JpaTransactionManager();
      txManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getObject());
      return txManager;
   }

   private Properties jpaProperties() {
      Properties jpaProperties = new Properties();
      jpaProperties.put("hibernate.hbm2ddl.auto", "create");
      jpaProperties.put("hibernate.hbm2ddl.import_files", "init.sql");
      return jpaProperties;
   }

   private JpaVendorAdapter jpaVendorAdapter() {
      HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
      hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
      hibernateJpaVendorAdapter.setGenerateDdl(true);
      return hibernateJpaVendorAdapter;
   }
}
