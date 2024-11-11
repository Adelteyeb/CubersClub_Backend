package com.CentreCulturel.demo.superAdmin;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreResponse;
@Service
public class SupperAdminMapper {
	public SupperAdmin tosupperadmin(SupperAdminRequest supReq) {
		
		 return SupperAdmin.builder()
				 .id(supReq.getId())
				 .firstName(supReq.getFirstName())
				 .lastName(supReq.getLastName())
				 .email(supReq.getEmail())
				 .password(supReq.getPassword())
				  
				  .url(supReq.getUrl())
				 
				 //.messages(supReq.getMessages())
				 .build();
}
	public SupperAdminResponse tosuperadminDTO(SupperAdmin supAdmin) {
		
		 return SupperAdminResponse.builder()
				 .id(supAdmin.getId())
				 .firstName(supAdmin.getFirstName())
				 .lastName(supAdmin.getLastName())
				 .email(supAdmin.getEmail())
				 .password(supAdmin.getPassword())
				
				 .url(supAdmin.getUrl())
				 //.roles(supAdmin.getRoles())
				 //.messages(supAdmin.getMessages())
				 .build();
	}
}
