package com.CentreCulturel.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CentreCulturel.demo.administrateur.AdminResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Users")
public class UserController {
	
	private final UserServiceImpl service;
	@GetMapping("/login")
	public ResponseEntity<UserResponse> findUserByEmailAndPassword(@RequestParam String email,
			@RequestParam String password) {
		return ResponseEntity.ok(service.loadUserByEmailAndPassword(email, password));
	}
	@GetMapping("/{user-id}")
	public ResponseEntity<UserResponse> findByid(@PathVariable(value = "user-id") Integer id){
		return ResponseEntity.ok(service.findById(id));
	}
	@GetMapping("/Message/{message-id}")
	public ResponseEntity<UserResponse> findByUserByMessageid(@PathVariable(value = "message-id") Integer id){
		return ResponseEntity.ok(service.findUserByMessagesId(id));
	}
	
	   
}
