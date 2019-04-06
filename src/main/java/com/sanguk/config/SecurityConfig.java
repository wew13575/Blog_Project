package com.sanguk.config;

import javax.sql.DataSource;

import com.sanguk.security.CustomUserDetailsService;

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

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/js/**", "image/**", "/fonts/**", "lib/**");
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/**/post").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll().and()
        .formLogin().loginPage("/").usernameParameter("name").passwordParameter("password").and().logout()
        .logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/403").and()

        .csrf().ignoringAntMatchers("/**");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
  }
}