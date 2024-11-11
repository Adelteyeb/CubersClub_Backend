package com.CentreCulturel.demo.evenementscientifique;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentreCulturel.demo.culturel.Culturel;

public interface ScientifiqueRepository extends JpaRepository<Scientifique, Integer> {
Optional<Scientifique> findByDateCreation(LocalDate date);
Optional<List<Scientifique>> findEventScientifiqueByDepartementsId(Integer id);
Optional<List<Scientifique>> findEventSientifiqueByListUtilisateurId(Integer id);
}
