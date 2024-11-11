package com.CentreCulturel.demo.culturel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.CentreCulturel.demo.evenementscientifique.ScientifiqueRequest;

public interface CulturelService {
	Integer save(CulturelRequest sientreq,Integer id);
	CulturelResponse findById(Integer id);
    List<CulturelResponse> findAll();
    CulturelResponse findByDateCreation(LocalDate date);
    void deleteById(Integer id);
    List<CulturelResponse> findEventCulturelByDepartementId(Integer id);
    void assignementUserToEventCulturel(Integer eventid , Integer userId);
    List<CulturelResponse> ListEventByUtilisateur(Integer id);
    Integer edit(CulturelRequest cultreq, Integer id);
}

