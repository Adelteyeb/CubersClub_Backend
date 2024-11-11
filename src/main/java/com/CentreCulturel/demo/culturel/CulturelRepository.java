package com.CentreCulturel.demo.culturel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CentreCulturel.demo.evenementscientifique.Scientifique;
public interface CulturelRepository extends JpaRepository<Culturel, Integer> {
	Optional<Culturel> findByDateCreation(LocalDate date);
	Optional<List<Culturel>> findEventCulturelByDepartementsId(Integer id);
	Optional<List<Culturel>> findEventCulturelByListUtilisateurId(Integer id);
    
}
