package com.helpezee.microservices.SpringBootHttpBasicSecurityUsingInMemory;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true ,securedEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.inMemoryAuthentication()
        .withUser("chandra").password("{noop}1234").roles("USER").and()
        .withUser("admin").password("{noop}admin123").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and().authorizeRequests()
        		// addItem and delete functionality only accessable to ADMIN only
                .antMatchers("/addItem","/delete").hasRole("ADMIN") 
             // getAllItems functionality only accessable to USER only
                .antMatchers("/getAllItems").hasRole("USER")
                .and().csrf().disable().headers().frameOptions().disable();
    }

}
