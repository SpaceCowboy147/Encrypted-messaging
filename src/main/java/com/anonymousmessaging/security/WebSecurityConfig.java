package com.anonymousmessaging.security;

import com.anonymousmessaging.users.UserAuthorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

    @Autowired
    private DataSource dataSource;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()

                .requestMatchers("/main", "/login", "/loginServlet", "/registration", "/registration/registerUser").permitAll()
                .requestMatchers( "/user/**").hasAnyAuthority("USER")
                .requestMatchers( "/admin/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()


                .formLogin(form -> {
                    try {
                        form
                                .loginPage("/login")
                        .loginProcessingUrl("/loginServlet")
                        .defaultSuccessUrl("/main", true)
                        .failureUrl("/login-error")

                        .and()
                        .logout()
                        .logoutUrl("/logout")
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/login?logout");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                        return http.build();


    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);

        manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");
        manager.setAuthoritiesByUsernameQuery("SELECT username, authorities FROM users WHERE username = ?");
        return manager;
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }
}
