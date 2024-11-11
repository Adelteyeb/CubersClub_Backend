package com.CentreCulturel.demo.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.config.JwtService;
import com.CentreCulturel.demo.user.EnumRole;
import com.CentreCulturel.demo.user.Role;
import com.CentreCulturel.demo.user.RoleRepository;
import com.CentreCulturel.demo.user.User;
import com.CentreCulturel.demo.user.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthentificationService {
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepo;
	private final RoleRepository roleRepo;
	private final JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;

	public AuthentificationResponse registrer(RegisterRequest request) {
		Role userRole = roleRepo.findByName(EnumRole.ROLE_USER).orElseGet(

				() -> {
					var newStudentRole = Role.builder().name(EnumRole.ROLE_USER).build();
					return roleRepo.save(newStudentRole);
				}

		);

		var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
				.email(request.getEmail()).url(request.getUrl()).password(passwordEncoder.encode(request.getPassword()))
				.roles(List.of(userRole))
				.build();
		userRepo.save(user);
		var jwttoken = jwtService.generatetoken(user);
		return AuthentificationResponse.builder().token(jwttoken).build()

		;
	}
	public AuthentificationResponse authenticate( AuthenticateRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var user=userRepo.findByEmail(request.getEmail()).orElseThrow();
		var jwttoken = jwtService.generatetoken(user);
		return AuthentificationResponse.builder().token(jwttoken).build();
	}
}
