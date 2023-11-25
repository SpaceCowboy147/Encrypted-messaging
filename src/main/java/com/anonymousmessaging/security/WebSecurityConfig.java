package com.anonymousmessaging.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired DataSource dataSource;
    @Bean
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

     auth.jdbcAuthentication()
             .dataSource(dataSource)
             .passwordEncoder(new BCryptPasswordEncoder())
             .usersByUsernameQuery("select username, password, enabled from users where username=?")
             .authoritiesByUsernameQuery("select username, authorities from users where username=?");


    }

    @Bean
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login").permitAll();


    }
}
