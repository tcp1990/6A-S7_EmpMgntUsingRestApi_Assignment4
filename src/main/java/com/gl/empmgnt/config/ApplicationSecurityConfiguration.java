package com.gl.empmgnt.config;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.empmgnt.service.DomainUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final DomainUserDetailsService userDetailsService;

	// setup users and permissions
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// configure authorization rules here
		httpSecurity.cors().disable();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		httpSecurity.authorizeRequests().antMatchers(POST, "/api/employees/**").hasRole("ADMIN");
		httpSecurity.authorizeRequests().antMatchers(PUT, "/api/employees/**",  "/api/roles/**", "/api/users/**").denyAll();
		httpSecurity.authorizeRequests().antMatchers(DELETE, "/api/roles/**", "/api/users/**").denyAll();
		//httpSecurity.authorizeRequests().antMatchers("/h2-console/**", "/login**", "/contact-us**").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/**").permitAll();
		httpSecurity.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic()
				/*
				 * Set the session creation policy to avoid using cookies for authentication
				 * https://stackoverflow.com/questions/50842258/spring-security-caching-my-
				 * authentication/50847571
				 */
				.and().sessionManagement().sessionCreationPolicy(STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		// configure users
		authenticationManagerBuilder.userDetailsService(this.userDetailsService)
				.passwordEncoder(bcryptPasswordEncoder());
	}

	@Primary
	@Bean
	public PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}