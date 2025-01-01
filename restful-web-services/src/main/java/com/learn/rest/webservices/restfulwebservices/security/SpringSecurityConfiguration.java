package com.learn.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// All requests should be authenticated
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		// If a request in not authenticated a web page is shown
		http.httpBasic(Customizer.withDefaults());
		
		// CSRF -> POST,PUT
		// Spring security would not block incoming post requests after proper authorization
		// credentials are passed
		http.csrf().disable();
		
		return http.build();
	}
}
