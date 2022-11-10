package com.springhms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springhms.filter.jwtFilter;
import com.springhms.serviceimpl.myUserDetailsService;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {

	 
	// Here we are performing security related configuration 
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
    private jwtFilter jwtFilter;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService);
  }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
	return NoOpPasswordEncoder.getInstance();
  }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    
    return super.authenticationManagerBean();
 }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

	http.csrf().disable().authorizeRequests().antMatchers("/user/authentication").permitAll()
	.anyRequest().authenticated().and()
	.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

}

}