package com.example.sistema;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class ConfiguracaoBd {
  @Bean
  public DataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/sistema");
    dataSource.setUsername("sistema");
    dataSource.setPassword("123456");
    return dataSource;
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter(){
    HibernateJpaVendorAdapter adapater = new HibernateJpaVendorAdapter();
    adapater.setDatabase(Database.MYSQL);
    adapater.setShowSql(true);
    adapater.setGenerateDdl(true);
    adapater.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
    adapater.setPrepareConnection(true);
    return adapater;
  }
}
