package com.springsecurty.springRestSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    //Now this data will act as login credtenial to load data of employeees, By default property
    //of spring security will get overlapped by these credentials.
    /*
    *
    *This data are used as authentication
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails John = User.builder()
                .username("John").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails Mary = User.builder()
                .username("Mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails Koar = User.builder()
                .username("Koar").password("{noop}test123").roles("EMPLOYEE", "MANAGER","ADMIN").build();
        return new InMemoryUserDetailsManager(John,Mary,Koar);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
      httpSecurity.authorizeHttpRequests(configurer ->
              configurer.requestMatchers(HttpMethod.GET,"/api/employee").hasRole("EMPLOYEE")
                      .requestMatchers(HttpMethod.GET,"/api/employee/**").hasRole("EMPLOYEE")
                      .requestMatchers(HttpMethod.POST,"/api/employee").hasRole("MANAGER")
                      .requestMatchers(HttpMethod.PUT,"/api/employee").hasRole("MANAGER")
                      .requestMatchers(HttpMethod.DELETE,"/api/employee/**").hasRole("ADMIN"));
      httpSecurity.httpBasic(Customizer.withDefaults());
      return httpSecurity.build();
    }
}
