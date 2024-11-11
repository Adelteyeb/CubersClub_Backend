package com.CentreCulturel.demo.config;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class JwtAuthentificationFilter extends OncePerRequestFilter {
private final JwtService jwtservice;
private final UserDetailsService userDetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		// Check the jwt token
		 final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		 final String jwt;
		 final String userEmail;
		 if(authHeader==null || authHeader.startsWith("Bearer ")) {
			 filterChain.doFilter(request, response);
			 return;
		 }
		// extract the token from authHeader
		 jwt=authHeader.substring(7);
		
		// extract the usernale  from tocken we need a JwtService Classe
		 userEmail= jwtservice.extarctuserEmail(jwt) ; //todo
		 if(userEmail != null && SecurityContextHolder.getContext().getAuthentication()==null) {
			 UserDetails userDetails=this.userDetailsService.loadUserByUsername(userEmail);
		     //if tocken is valid then update the SecurityContext
			 if(jwtservice.istockenvalid(jwt, userDetails)) {
				 UsernamePasswordAuthenticationToken authtoken =new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				 
				authtoken.setDetails(new WebAuthenticationDetailsSource()
						.buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authtoken);
			 }
		 }
		 filterChain.doFilter(request, response);
	}

}
