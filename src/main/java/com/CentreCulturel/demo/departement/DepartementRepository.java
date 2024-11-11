package com.CentreCulturel.demo.departement;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentreCulturel.demo.idee.Idee;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
	Optional<Departement> findDepartementByAdministrateurId(Integer id);
	Optional<Departement> findByName(String name);
	//Optional<Departement> findDepartementByUtilisateurId(Integer id);
	
}
