package com.CentreCulturel.demo.administrateur;

import java.util.List;
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
public class AdminResponse {
	private Integer id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String role;
	private String url;
    private List<Message> messages;
}
