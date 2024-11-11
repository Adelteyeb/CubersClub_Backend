package com.CentreCulturel.demo.membre;

import org.springframework.stereotype.Service;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Service
public class MembreMapper {
 
	public Membre toututilisateur(MembreRequest utlReq) {
		 Membre utls = new Membre();
		 return utls.builder()
				 .id(utlReq.getId())
				 .firstName(utlReq.getFirstName())
				 .lastName(utlReq.getLastName())
				 .email(utlReq.getEmail())
				 .password(utlReq.getPassword())
				
				 .url(utlReq.getUrl())
				// .roles(utlReq.getRoles())
				// .messages(utlReq.getMessages())
				 .build();
	 }

public MembreResponse toutlisateurDTO(Membre utl) {
	
	 return MembreResponse.builder()
			 .id(utl.getId())
			 .firstName(utl.getFirstName())
			 .lastName(utl.getLastName())
			 .email(utl.getEmail())
			 .password(utl.getPassword())
			 
			 .url(utl.getUrl())
			 //.messages(utl.getMessages())
			 .build();
}
}
