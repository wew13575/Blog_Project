package com.sanguk.config;

import javax.sql.DataSource;

import com.sanguk.security.CustomUserDetailsService;
import com.sanguk.security.LoginFailureHandler;
import com.sanguk.security.LoginSuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Configurable
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Bean
  public UserDetailsService customUserService() {
    return new CustomUserDetailsService();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public LoginFailureHandler loginFailureHandler(){
    return new LoginFailureHandler();
  }

  @Bean
  public LoginSuccessHandler loginSuccessHandler(){
    return new LoginSuccessHandler();
  }


  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/js/**", "image/**", "/fonts/**", "lib/**");
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
    .authorizeRequests()
    .antMatchers("/admin/editor").access("hasRole('ROLE_ADMIN')") //TODO 글 list 제외하고 나머지 제한할것
    .antMatchers("/board/editor").access("hasRole('ROLE_MEMBER')") //TODO 댓글 list 제외하고 나머지 제한할것
    .anyRequest().permitAll() //TODO 마이페이지 제한할것
    .and()
    .formLogin().loginProcessingUrl("/user/login.do").loginPage("/").usernameParameter("loginid").passwordParameter("loginpw")
    .successHandler(loginSuccessHandler())
    .failureHandler(loginFailureHandler())
    .and()
    .logout().logoutSuccessUrl("/user/logout.do").invalidateHttpSession(true)
    .and()
    .exceptionHandling().accessDeniedPage("/")
    .and()
    .csrf().ignoringAntMatchers("/**");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
  }
}