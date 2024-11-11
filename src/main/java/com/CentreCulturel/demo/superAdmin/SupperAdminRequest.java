package com.CentreCulturel.demo.superAdmin;

import java.util.List;

import com.CentreCulturel.demo.message.Message;
import com.CentreCulturel.demo.user.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
public class SupperAdminRequest {
	private Integer id;
	@NotNull(message = "First name must be not null")
	private String firstName;
	@NotNull(message = "Last name must be not null")
	private String lastName;
	@NotNull(message = "password name must be not null")
	private String password;
	@Email
	private String email;
	private String url;
    private String role;
    
    //private List<Role> roles;
    //private List<Message> messages;
}