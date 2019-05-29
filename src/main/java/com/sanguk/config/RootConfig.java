package com.sanguk.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.sql.DataSource;

import com.sanguk.aop.ExeTimeAspect;
import com.sanguk.mapper.UserMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan(basePackages = { "com.sanguk" })
@MapperScan(basePackages = { "com.sanguk.mapper" })
public class RootConfig {

  @Autowired
  private ResourceLoader resourceLoader;

  @Bean
  public DataSource dataSource() {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
    hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/springpj?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false");

    hikariConfig.setUsername("root");
    hikariConfig.setPassword("tfn12127");
    //hikariConfig.setUsername("sanguk");
    //hikariConfig.setPassword("dnTkddnr!1");
    //blogsangukdnTkddnr!1

    //TODO: 서버환경에맞게변경!

    hikariConfig.setMinimumIdle(5);
    // test Query
    hikariConfig.setPoolName("springHikariCP");

    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "200");
    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

    return dataSource;
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
    sqlSessionFactory.setDataSource(dataSource());
    sqlSessionFactory.setMapperLocations(ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
        .getResources("classpath:com/sanguk/mapper/*.xml"));

    return (SqlSessionFactory) sqlSessionFactory.getObject();
  }
  
  
  @Bean
  public SqlSessionTemplate sqlSession() throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory());
  }

  @Bean
  public DataSourceTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  public String imagePath() {
    //return "/usr/local/image/";
    return "C:/image/";
  }

  @Bean
  public Path imageLocation(){
    return Paths.get(imagePath());
  }

  @Bean
  public String thumnailPath() {
    //return "/usr/local/thumnail/";
    return "C:/thumnail/";
  }

  @Bean
  public Path thumnailLocation(){
    return Paths.get(thumnailPath());
  }
  
  @Bean
  public String profilePath() {
    //return "/usr/local/profile/";
    return "C:/profile/"; 
  }

  @Bean
  public Path profileLocation() {
    return Paths.get(profilePath());
  }

  @Bean
  public int numOfBasicProfile(){
    return 3;
  }

  


  @Bean
  public MultipartResolver multipartResolver() {
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    resolver.setMaxInMemorySize(100000000);
    resolver.setMaxUploadSize(200000000);
    return resolver;
  }


/* 
  @Bean
  public ExeTimeAspect timeAspect(){
    return new ExeTimeAspect();
  } */
}