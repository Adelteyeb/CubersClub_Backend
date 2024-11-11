package com.CentreCulturel.demo.idee;

import java.sql.Date;

import com.CentreCulturel.demo.membre.Membre;

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
public class IdeeResponse {
    private Integer id;
	private String name;
	private String description;
	//private Date dateCreation;
	//private Utilisateur utilisateur;
}
