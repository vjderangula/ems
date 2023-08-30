package com.sreenu.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EMSSecurityConfigUpgraded {
	
	@Bean
	protected UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user = User.withUsername("Derangula")
				.password(passwordEncoder.encode("Kumar1"))
				.roles("USER").build();
		UserDetails adminUser = User.withUsername("Narayan")
				.password(passwordEncoder.encode("Derangula1"))
				.roles("Admin","USER").build();
		UserDetails admin = User.withUsername("Moneeshwar")
				.password(passwordEncoder.encode("Derangula1"))
				.roles("Admin").build();
		return new InMemoryUserDetailsManager(user,adminUser,admin);
		
	}
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
				
		return http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.and()
		.authorizeRequests().antMatchers("/welcome", "/text")
		.authenticated().and().httpBasic().and().build();
	}
	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

}
