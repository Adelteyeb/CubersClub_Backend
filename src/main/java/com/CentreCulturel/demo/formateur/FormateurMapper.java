package com.CentreCulturel.demo.formateur;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreResponse;

@Service
public class FormateurMapper {
 
	public Formateur toformateur(FormateurRequest formReq) {
		 Formateur form = new Formateur();
		 return form.builder()
				 .firstName(formReq.getFirstName())
				 .lastName(formReq.getLastName())
				 .email(formReq.getEmail())
				 .password(formReq.getPassword())
				 //.role(formReq.getRole())
				 .url(formReq.getUrl())
				 .build();
	 }

public FormateurResponse toformateurDTO(Formateur form) {
	
	 return FormateurResponse.builder()
			 .firstName(form.getFirstName())
			 .lastName(form.getLastName())
			 .email(form.getEmail())
			 .password(form.getPassword())
			 //.role(form.getRole())
			 .url(form.getUrl())
			 .messages(form.getMessages())
			 .build();
}
}
