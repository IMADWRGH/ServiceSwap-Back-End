package com.ServiceSwap.Configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;



@Component // or @service annotation
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
         @NonNull HttpServletRequest request,
         @NonNull  HttpServletResponse response,
         @NonNull  FilterChain filterChain
    ) throws ServletException, IOException {
    final String authHeader =request.getHeader("Authorization");
        String jwt = "";
        String userEmail = "";
        System.out.println("authHeader: " + authHeader);
    if (authHeader==null || !authHeader.startsWith("Bearer ")){
        filterChain.doFilter(request,response);
        return;
    }
    jwt=authHeader.substring(7);
    System.out.println("jwt: " + jwt);
    userEmail=jwtService.extractUserEmail(jwt);
        System.out.println("userEmail: " + userEmail);//extract th email from JWT I need  class JwtService
        if (userEmail!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=this.userDetailsService.loadUserByUsername(userEmail);
            if (jwtService.isJwtValid(jwt,userDetails)){
                UsernamePasswordAuthenticationToken authToken =new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
