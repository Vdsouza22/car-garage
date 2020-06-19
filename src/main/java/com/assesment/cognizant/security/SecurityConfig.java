package com.assesment.cognizant.security;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
/**
 * Class to enable authentication and set username , password
 * Only for development purpose ( not recommended )
 * @author Vinita
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http
         .csrf().disable()
         .authorizeRequests().antMatchers("/api/cars").permitAll().antMatchers("/api/cars/**").permitAll().anyRequest().authenticated()
         .and()
         .httpBasic();
    }
  
 
}