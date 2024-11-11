package com.CentreCulturel.demo.artiste;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentreCulturel.demo.membre.Membre;

public interface ArtisteRepository extends JpaRepository<Artiste, Integer> {
	Optional <Artiste> findByEmail(String email);

	Optional <List<Artiste>>findByFirstNameAndLastName(String firstName, String lastName);
}
