package com.helpezee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// authentication
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("satya")
				.password("satya").roles("USER");
	}

	// authorication
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("USER")
				.and()
				.formLogin()
				.loginPage("/login.jsp")
				.failureUrl("/login.jsp?error=1")
				.loginProcessingUrl("/login")
				.permitAll()
				.and()
				.logout()
				.logoutSuccessUrl("/listEmployees.html");

	}

}
