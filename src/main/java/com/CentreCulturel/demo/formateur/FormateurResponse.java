package com.CentreCulturel.demo.formateur;

import java.util.List;

import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.message.Message;
import com.CentreCulturel.demo.user.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FormateurResponse {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String url;
    private String role;
    private List<Message> messages;

}

