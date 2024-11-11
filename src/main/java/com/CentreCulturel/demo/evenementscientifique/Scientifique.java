package com.CentreCulturel.demo.evenementscientifique;

import java.util.List;

import com.CentreCulturel.demo.artiste.Artiste;
import com.CentreCulturel.demo.culturel.Culturel;
import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.formateur.Formateur;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Entity
@DiscriminatorValue("SCIENT")
public class Scientifique extends Evenement{
	@JsonManagedReference
	@ManyToMany(mappedBy = "scientifiques")
	private List<Formateur> formateurs;
}
