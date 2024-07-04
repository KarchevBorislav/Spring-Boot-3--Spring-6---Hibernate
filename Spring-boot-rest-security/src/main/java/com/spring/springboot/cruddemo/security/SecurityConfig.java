package com.luv2code.springboot.cruddemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test1")
                .roles("EMPLOYEE")
                .build();

        UserDetails marry = User.builder()
                .username("marry")
                .password("{noop}test2")
                .roles("EMPLOYEE", "MANAGER")
                .build();


        UserDetails chris = User.builder()
                .username("chris")
                .password("{noop}test3")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();


        return new InMemoryUserDetailsManager(john, marry, chris);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );


        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery(CSRF)
        // In general not required for stateless REST APIs that use POST,PUT, DELETE

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();

    }
}
