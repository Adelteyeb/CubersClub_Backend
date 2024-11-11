package com.CentreCulturel.demo.superAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentreCulturel.demo.membre.Membre;

public interface SupperAdminRepository extends JpaRepository<SupperAdmin, Integer>  {
	Optional <List<SupperAdmin>>findByFirstNameAndLastName(String firstName, String lastName);
	Optional <SupperAdmin> findByEmail(String email);
	}

