package com.CentreCulturel.demo.user;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.superAdmin.SupperAdmin;
import com.CentreCulturel.demo.superAdmin.SupperAdminResponse;

@Service
public class UserMapper {
	public User toUser(UserRequest req) {
		
		return User.builder()
				
				  .id(req.getId())
				 .firstName(req.getFirstName())
				 .lastName(req.getLastName())
				 .email(req.getEmail())
				 .password(req.getPassword())
				  .url(req.getUrl())
				 
				 .build();
}
	public UserResponse touserDTO(User user) {
		 return UserResponse.builder()
				 .id(user.getId())
				 .firstName(user.getFirstName())
				 .lastName(user.getLastName())
				 .email(user.getEmail())
				 .password(user.getPassword())
				
				 .url(user.getUrl())
				
				 .build();
	}
	

}
