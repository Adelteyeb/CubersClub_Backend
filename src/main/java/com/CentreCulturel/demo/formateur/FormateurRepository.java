package com.CentreCulturel.demo.formateur;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentreCulturel.demo.membre.Membre;

public interface FormateurRepository extends JpaRepository<Formateur, Integer>{
	Optional <Formateur> findByEmail(String email);

	Optional <List<Formateur>>findByFirstNameAndLastName(String firstName, String lastName);

	

}
