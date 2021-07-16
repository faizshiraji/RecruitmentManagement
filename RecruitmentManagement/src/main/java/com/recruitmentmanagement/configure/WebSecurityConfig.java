package com.recruitmentmanagement.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.recruitmentmanagement.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder	passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
		.csrf().disable()
		.authorizeRequests().antMatchers("/admin/**").hasAuthority("USER")
		.antMatchers("/registration", "/process_registration", "/userhome", "/landing", "/order", "/jobdetails/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.usernameParameter("userName")
			.defaultSuccessUrl("/admin/home", true)
			.loginPage("/login")
			.failureUrl("/login?error=true")
			.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/login")
		.deleteCookies("JSESSIONID")
		.logoutSuccessHandler(logoutSuccessHandler())
		.permitAll()
		.and()
		.rememberMe()
		.and()
		.logout().permitAll();
		
	}
	
	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring().antMatchers("/webjars/**",
											"/css/**", 
											"/js/**",
											"/images/**",
											"/node_modules/**",
											"/bower_components/**");
	}

	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(userDetailsService);
		return authenticationProvider;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authProvider());
	}
	
}
