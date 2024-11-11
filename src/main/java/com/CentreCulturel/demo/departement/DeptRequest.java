package com.CentreCulturel.demo.departement;

import java.sql.Date;
import java.util.List;

import com.CentreCulturel.demo.administrateur.Administrateur;
import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.evenement.EventRequest;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreRequest;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptRequest {
	private Integer id;
	@NotNull(message = "Name must be not null")
	private String name;
	@NotNull(message = "Description must be not null")
	private String description;
	
	//private Administrateur adminidtrateur;
	
	//private List<Utilisateur> listUtilisateur;
	
	//private List<Evenement> evenements;
}
