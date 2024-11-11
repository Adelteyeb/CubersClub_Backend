package com.CentreCulturel.demo.membre;

import java.util.List;

import com.CentreCulturel.demo.message.Message;
import com.CentreCulturel.demo.user.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MembreResponse {
	private Integer id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
    private String role;
    private String url;
    private List<Message> messages;

}
