package com.CentreCulturel.demo.artiste;

import java.sql.Date;
import java.util.List;

import com.CentreCulturel.demo.base.BaseClass;
import com.CentreCulturel.demo.culturel.Culturel;
import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@DiscriminatorValue("ART")
public class Artiste extends User {
	@JsonBackReference
	@ManyToMany
	@JoinTable(name="event_artistique_artiste",
			joinColumns=@JoinColumn(name="CULT_ID",referencedColumnName = "Id"),
			inverseJoinColumns = @JoinColumn(name="ART_ID",referencedColumnName = "Id"))
	private List<Culturel> culturels;

}
