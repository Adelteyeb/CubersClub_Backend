package com.CentreCulturel.demo.membre;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentreCulturel.demo.departement.Departement;

public interface MembreRepository extends JpaRepository<Membre, Integer> {
Optional <Membre> findByEmail(String email);

Optional <List<Membre>>findByFirstNameAndLastName(String firstName, String lastName);
Optional<List<Membre>> findByDepartementId(Integer id);
Optional<List<Membre>> findByEvenementsId(Integer id);



}
