package com.ServiceSwap.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/signup").permitAll()
//                .antMatchers("/api/login").permitAll()
//                .antMatchers("/api/admin/**").hasAuthority("ADMIN")
//                .antMatchers("/api/customer/**").hasAuthority("CUSTOMER")
//                .antMatchers("/api/seller/**").hasAuthority("SELLER")
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtTokenProvider))
//                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtTokenProvider))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//}

