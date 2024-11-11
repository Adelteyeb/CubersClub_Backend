package com.CentreCulturel.demo.evenement;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.CentreCulturel.demo.base.BaseClass;
import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.membre.Membre;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class EventRequest {
	private Integer id;
	@NotNull(message = "Name must be not null")
	private String name;
	@NotNull(message = "Description must be not null")
	private String description;
	@NotNull(message = "Date must be not null")
	private LocalDate dateCreation;
	@NotNull(message = "Theme must be not null")
	private String theme;
	
	
	//private Departement departements;
	
	//private List<Utilisateur> listUtilisateur;

}
