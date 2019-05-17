package com.demo.service;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.context.ShutdownEndpoint;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ActuatorSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	 @Override
	 public UserDetailsService userDetailsService() {
	  UserDetails user = User.withDefaultPasswordEncoder()
	    .username("admin")
	    .password("123")
	    .roles("ADMIN")
	    .build();
	  return new InMemoryUserDetailsManager(user);
	 }
	 
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests()
	 * .requestMatchers(EndpointRequest.to(ShutdownEndpoint.class))
	 * .hasRole("ACTUATOR_ADMIN") .requestMatchers(EndpointRequest.toAnyEndpoint())
	 * .permitAll()
	 * .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
	 * .permitAll() .antMatchers("/") .permitAll() .antMatchers("/**")
	 * .authenticated() .and() .httpBasic(); }
	 */
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	  http.httpBasic().and().authorizeRequests()
	   .antMatchers("/user/**").hasRole("ADMIN")
	   .and().csrf().disable().headers().frameOptions().disable();
	 }

}
