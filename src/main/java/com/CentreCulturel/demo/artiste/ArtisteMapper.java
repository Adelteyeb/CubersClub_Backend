package com.CentreCulturel.demo.artiste;

import org.springframework.stereotype.Service;


@Service
public class ArtisteMapper {
 
	public Artiste toartiste(ArtisteRequest artreq) {
		 Artiste art = new Artiste();
		 return art.builder()
				 .firstName(artreq.getFirstName())
				 .lastName(artreq.getLastName())
				 .email(artreq.getEmail())
				 .password(artreq.getPassword())
				
				 .url(artreq.getUrl())
				// .roles(utlReq.getRoles())
				// .messages(utlReq.getMessages())
				 .build();
	 }

public ArtisteResponse toartisteDTO(Artiste art) {
	
	 return ArtisteResponse.builder()
			 .firstName(art.getFirstName())
			 .lastName(art.getLastName())
			 .email(art.getEmail())
			 .password(art.getPassword())
			 
			 .url(art.getUrl())
			 .messages(art.getMessages())
			 .build();
}
}
