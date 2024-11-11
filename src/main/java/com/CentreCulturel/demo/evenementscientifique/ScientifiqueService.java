package com.CentreCulturel.demo.evenementscientifique;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.CentreCulturel.demo.culturel.CulturelResponse;

public interface ScientifiqueService {
	Integer save(ScientifiqueRequest sientreq, Integer id);
	ScientifiqueResponse findById(Integer id);
    List<ScientifiqueResponse> findAll();
    ScientifiqueResponse findByDateCreation(LocalDate date);
    void deleteById(Integer id);
    List<ScientifiqueResponse> ListEventSicentifiqueByIdDepartement(Integer id);
    void assignementUserToEventScientifique(Integer eventid , Integer userId);
    List<ScientifiqueResponse> ListEventByUtilisateur(Integer id);
    Integer edit(ScientifiqueRequest sientreq, Integer id);

}
