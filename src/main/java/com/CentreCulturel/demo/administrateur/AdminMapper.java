package com.CentreCulturel.demo.administrateur;

import org.springframework.stereotype.Service;

@Service
public class AdminMapper {
	public Administrateur toadministrateur(AdminRequest adminReq) {
		
		 return Administrateur.builder()
				 .id(adminReq.getId())
				 .firstName(adminReq.getFirstName())
				 .lastName(adminReq.getLastName())
				 .email(adminReq.getEmail())
				 .password(adminReq.getPassword())
				
				 .url(adminReq.getUrl())
				 //.roles(adminReq.getRoles())
				 //.messages(adminReq.getMessages())
				 .build();
	 }

public AdminResponse toadmistrateurDTO(Administrateur admin) {
	
	 return AdminResponse.builder()
			 .id(admin.getId())
			 .firstName(admin.getFirstName())
			 .lastName(admin.getLastName())
			 .email(admin.getEmail())
			 .password(admin.getPassword())
			 
			 .url(admin.getUrl())
			 
			 .build();
}
}
