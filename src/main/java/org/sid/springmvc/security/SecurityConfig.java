package org.sid.springmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

     http.formLogin();

     http.authorizeRequests().antMatchers("/save**/**","/form**/**","/delete**/**").hasRole("ADMIN");
     http.authorizeRequests().anyRequest().authenticated();
     http.csrf();
     http.exceptionHandling().accessDeniedPage("/notAuthorized");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pass= passwordEncoder();

        auth.inMemoryAuthentication().withUser("user").password(pass.encode("1234")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(pass.encode("12345")).roles("ADMIN","USER");
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
