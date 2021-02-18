package com.timberliu.springboot.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author: Timber
 * @date: 2021/2/7
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("normal").password("normal").roles("NORMAL");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test/hello").permitAll()
                .antMatchers("/test/admin").hasRole("ADMIN")
                .antMatchers("/test/normal").access("hasRole('ROLE_NORMAL')")
                .anyRequest().authenticated()
            .and()
                .formLogin()
//                .loginPage("/login")
                .permitAll()
            .and()
                .logout()
//                .logoutUrl("/logout")
                .permitAll();
    }
}
