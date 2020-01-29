package com.endava.springc7e1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails u1 = User.withUsername("john")
//                .password("12345")
//                .authorities("write")
//                .build();
//
//        UserDetails u2 = User.withUsername("bill")
//                .password("12345")
//                .authorities("read")
//                .build();
//
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        userDetailsManager.createUser(u1);
//        userDetailsManager.createUser(u2);
//
//        return userDetailsManager;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest()
                .access("hasAnyAuthority('read')");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
