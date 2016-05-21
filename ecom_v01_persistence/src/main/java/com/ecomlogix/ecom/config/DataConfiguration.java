package com.ecomlogix.ecom.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.ecomlogix.ecom")
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class DataConfiguration {

   public static final String PERSISTENCE_UNIT_NAME = "ecom";

   @Bean
   public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setUsername("root");
      dataSource.setPassword("root");
      dataSource.setUrl("jdbc:mysql://localhost/ecom_3");
      return dataSource;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
      HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
      jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
      jpaVendorAdapter.setGenerateDdl(false);

      Properties jpaProperties = new Properties();
      // jpaProperties.put("hibernate.hbm2ddl.auto", "create");
      // jpaProperties.put("hibernate.hbm2ddl.import_files", "init.sql");

      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
      factory.setDataSource(dataSource());
      factory.setJpaVendorAdapter(jpaVendorAdapter);
      factory.setJpaProperties(jpaProperties);
      factory.setPackagesToScan("com.ecomlogix.ecom.domain");
      factory.afterPropertiesSet();
      return factory;
   }

   @Bean
   public PlatformTransactionManager transactionManager() {
      JpaTransactionManager txManager = new JpaTransactionManager();
      txManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getObject());
      return txManager;
   }
}
