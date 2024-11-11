package com.CentreCulturel.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServlet;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiuration {
	// authentificationProvider for fetch user from db DAO: Data Access Object
	private final AuthenticationProvider AuthenticationProvider;
	private final JwtAuthentificationFilter JwtFilter;

	//@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 
		 //.csrf((csrf)->csrf.ignoringRequestMatchers("/no-csrf"))
		 //.csrf(AbstractHttpConfigurer::disable)
		 http.csrf(csrf -> csrf.disable())
		 .authorizeHttpRequests((authz) -> authz
				   .requestMatchers("api/auth/**").permitAll()
				   
	                .requestMatchers("/api/admin/**").hasRole("ADMIN")
	               .requestMatchers("/api/user/**").hasRole("USER")
	                .anyRequest().authenticated()
	            )
	     .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		 .authenticationProvider(AuthenticationProvider)
		 .addFilterBefore(JwtFilter, UsernamePasswordAuthenticationFilter.class);
		 return http.build();
	}
	

}
