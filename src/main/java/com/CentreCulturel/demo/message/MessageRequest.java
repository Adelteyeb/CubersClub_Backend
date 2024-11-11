package com.CentreCulturel.demo.message;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.CentreCulturel.demo.artiste.Artiste;
import com.CentreCulturel.demo.culturel.Culturel;
import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.evenement.EventRequest;
import com.CentreCulturel.demo.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.ManyToMany;
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
public class MessageRequest {
	private Integer id;
	private String titre;
	@NotNull(message = "Description must be not null")
	private String description;	
	private LocalDate dateCreation;
	
}
