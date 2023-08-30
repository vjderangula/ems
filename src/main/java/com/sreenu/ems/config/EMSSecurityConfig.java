/*
 * package com.sreenu.ems.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class EMSSecurityConfig extends
 * WebSecurityConfigurerAdapter{
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception{
 * 
 * auth.inMemoryAuthentication() .withUser("Derangula")
 * .password(passwordEncoder().encode("Kumar1")) .roles("USER");
 * 
 * auth.inMemoryAuthentication() .withUser("Narayan")
 * .password(passwordEncoder().encode("Derangula1")) .roles("USER");
 * 
 * auth.inMemoryAuthentication() .withUser("Moneeshwar")
 * .password(passwordEncoder().encode("Derangula1")) .roles("USER"); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http.authorizeRequests() .antMatchers("/home").permitAll() .and()
 * .authorizeRequests().antMatchers("/welcome", "/text")
 * .authenticated().and().httpBasic();
 * 
 * }
 * 
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); } }
 */