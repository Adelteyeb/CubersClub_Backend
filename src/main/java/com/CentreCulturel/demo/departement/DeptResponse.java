package com.CentreCulturel.demo.departement;

import java.util.List;

import com.CentreCulturel.demo.administrateur.Administrateur;
import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.membre.Membre;

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
public class DeptResponse {
	private Integer id;
	private String name;
	private String description;
	//private Administrateur administrateur;
	
	
}
