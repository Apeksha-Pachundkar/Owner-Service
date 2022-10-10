package com.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.owner.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	  @Autowired private MyUserDetailsService myUserDetailsService;
	 
	/*	
      Used by the default implementation of authenticationManager() 
       to attempt to obtain an AuthenticationManager.
	 */
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthProvider());
	/*
	 * auth.inMemoryAuthentication().withUser("harry").password(getPasswordEncoder()
	 * . encode("potter")).authorities("ADMIN") .and()
	 * .withUser("ronald").password(getPasswordEncoder().encode("weasley")).
	 * authorities( "USER");
	 */
		 
	}

	private AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
		auth.setUserDetailsService(myUserDetailsService);
		auth.setPasswordEncoder(passwordEncoder());
		
		return auth;
	}
	
	@Override //Override this method to configure HttpSecurity
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/user/register").permitAll()
//		                        .antMatchers(HttpMethod.GET,"/showowner").permitAll()                        
//		                        .antMatchers(HttpMethod.GET,"/showdept").permitAll()
//		                        .antMatchers(HttpMethod.POST,"/adddept").permitAll()
//		                        .antMatchers(HttpMethod.PUT,"/updatedept/**").permitAll()
//		                        .antMatchers(HttpMethod.DELETE,"/deletedept/**").permitAll()
//		                        .antMatchers(HttpMethod.GET,"/findAllRoom").permitAll()
//		                        .antMatchers(HttpMethod.GET,"/getAllEmp").permitAll()
//		                        .antMatchers(HttpMethod.GET,"/ShowAllReservations").permitAll()
//		                        .antMatchers(HttpMethod.GET,"/getAllGuest").permitAll()
		                       
		                       
		                        .anyRequest().permitAll()
				                .and().httpBasic()
				                .and().csrf()
				                .disable();

	}

	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
