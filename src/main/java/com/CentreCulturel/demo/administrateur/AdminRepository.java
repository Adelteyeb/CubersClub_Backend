package com.CentreCulturel.demo.administrateur;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentreCulturel.demo.membre.Membre;

public interface AdminRepository extends JpaRepository<Administrateur, Integer> {

	Optional<Administrateur> findByemail(String email);
	Optional <List<Administrateur>>findByFirstNameAndLastName(String firstName, String lastName);
	Optional<Administrateur> findAdminByDepartementId(Integer id);

}
