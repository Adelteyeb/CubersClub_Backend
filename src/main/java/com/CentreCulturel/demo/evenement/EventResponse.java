package com.CentreCulturel.demo.evenement;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.membre.Membre;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EventResponse {
	private Integer id;
	@NotNull(message = "Name must be not null")
	private String name;
	@NotNull(message = "Description must be not null")
	private String description;
	@NotNull(message = "Date must be not null")
	private LocalDate dateCreation;
	@NotNull(message = "Theme must be not null")
	private String theme;
	private String typeEvent;
	
	//private Departement departements;
	
	//private List<Utilisateur> listUtilisateur;

}
