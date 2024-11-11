package com.CentreCulturel.demo.idee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentreCulturel.demo.membre.Membre;

public interface IdeeRepository  extends JpaRepository<Idee, Integer> {
Optional<List<Idee>> findIdeeByUtilisateurId(Integer id);


}
