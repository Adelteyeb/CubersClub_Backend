package com.CentreCulturel.demo.administrateur;

import java.util.List;

import com.CentreCulturel.demo.culturel.Culturel;
import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("ADMIN")
public class Administrateur extends User {
	
	 @JsonBackReference
		@OneToOne(mappedBy = "administrateur",cascade = {CascadeType.MERGE,CascadeType.REFRESH})
		@JoinColumn(name="DEP_ID")
		private Departement departement;
	//private String nommmm;

}
