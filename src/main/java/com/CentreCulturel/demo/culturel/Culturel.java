package com.CentreCulturel.demo.culturel;

import java.sql.Date;
import java.util.List;

import com.CentreCulturel.demo.artiste.Artiste;
import com.CentreCulturel.demo.base.BaseClass;
import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.membre.Membre;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@DiscriminatorValue("CULT")
public class Culturel extends Evenement {
	@JsonManagedReference
	@ManyToMany(mappedBy = "culturels")
	private List<Artiste> artistes;

}
