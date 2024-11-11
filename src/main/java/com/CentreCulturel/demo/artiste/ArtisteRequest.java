package com.CentreCulturel.demo.artiste;
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

public class ArtisteRequest {
	private Integer id;
	@NotNull(message = "First name must be not null")
	private String firstName;
	@NotNull(message = "Last name must be not null")
	private String lastName;
	@NotNull(message = "password name must be not null")
	private String password;
	@Email
	private String email;
	private String role;
	private String url;
    
}

