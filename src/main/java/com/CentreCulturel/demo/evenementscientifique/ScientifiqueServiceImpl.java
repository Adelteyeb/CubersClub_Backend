package com.CentreCulturel.demo.evenementscientifique;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.culturel.Culturel;
import com.CentreCulturel.demo.culturel.CulturelResponse;
import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.departement.DepartementRepository;
import com.CentreCulturel.demo.departement.DeptRequest;
import com.CentreCulturel.demo.idee.Idee;
import com.CentreCulturel.demo.membre.MembreRepository;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreResponse;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ScientifiqueServiceImpl implements ScientifiqueService {
	private final ScientifiqueRepository repo;
	private final ScientifiqueMapper mapper;
	private final DepartementRepository deptrepo;
	private final MembreRepository utilirepo;
	@Override
	public Integer save(ScientifiqueRequest sientreq, Integer id) {
		// TODO Auto-generated method stub
		Departement departement =deptrepo.findById(id).orElse(new Departement());
		
		Scientifique sientifique =mapper.toscientifique(sientreq);
		sientifique.setDepartements(departement);
		
		/* long millis=System.currentTimeMillis(); 
		Date currentDate =new Date(millis);*/
	
		//sientifique.setDateCreation(currentDate);
		return repo.save(sientifique).getId();
	}

	@Override
	public ScientifiqueResponse findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(mapper::toscientifiqueDTO).orElse(new ScientifiqueResponse());
	}

	@Override
	public List<ScientifiqueResponse> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll().stream()
				             .map(mapper::toscientifiqueDTO)
				             .collect(Collectors.toList());
	}

	@Override
	public ScientifiqueResponse findByDateCreation(LocalDate date) {
		// TODO Auto-generated method stub
		return repo.findByDateCreation(date).map(mapper::toscientifiqueDTO).orElse(new ScientifiqueResponse());
	}

	@Override
	public void deleteById(Integer id) {
		Scientifique scientifique = repo.findById(id).orElse(new Scientifique());
        if (scientifique !=null) {
            
            // Remove the event from all users
            for (Membre user : scientifique.getListUtilisateur()) {
                user.getEvenements().remove(scientifique);
                utilirepo.save(user);
                scientifique.getListUtilisateur().remove(user);
                
                
            }
            repo.delete(scientifique);
            // Now delete the event
           
        }
		// TODO Auto-generated method stub
		//repo.deleteById(id);
	}

	@Override
	public List<ScientifiqueResponse> ListEventSicentifiqueByIdDepartement(Integer id) {
		// TODO Auto-generated method stub
		List<Scientifique> scientifiques = repo.findEventScientifiqueByDepartementsId(id).orElse(Collections.EMPTY_LIST);
	    List<ScientifiqueResponse> scientifiqueResponses = new ArrayList<>();

	    scientifiques.forEach(event->{ scientifiqueResponses.add(mapper.toscientifiqueDTO(event));});
    return scientifiqueResponses;
	}

	@Override
	public void assignementUserToEventScientifique(Integer eventId, Integer userId) {
		// TODO Auto-generated method stub
		Membre util =utilirepo.findById(userId).orElseThrow(()->new EntityNotFoundException("membre n 'existe pas avec Id ::" +userId));
		Scientifique scientifique=repo.findById(eventId).orElseThrow(()->new EntityNotFoundException("Evenement n 'existe pas avec Id ::" +eventId));
		
		 
		 util.getEvenements().add(scientifique);
		 scientifique.getListUtilisateur().add(util);
		 repo.save(scientifique);
		 utilirepo.save(util);
		
	}

	@Override
	public List<ScientifiqueResponse> ListEventByUtilisateur(Integer id) {
		List<Scientifique> scientifiques = repo.findEventSientifiqueByListUtilisateurId(id).orElse(Collections.EMPTY_LIST);
	    List<ScientifiqueResponse> scientifiquelResponses = new ArrayList<>();

	    scientifiques.forEach(event->{ scientifiquelResponses.add(mapper.toscientifiqueDTO(event));});
    return scientifiquelResponses;
		
	}

	@Override
	public Integer edit(ScientifiqueRequest sientreq, Integer id) {
		Scientifique scientifique =repo.findById(sientreq.getId())
				.orElseThrow(()-> new EntityNotFoundException("Event n existe pas avec L Id" + sientreq.getId()));
		Departement departement =deptrepo.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Departement n existe pas avec L Id" + id));
		
		Scientifique   scientifiquesave =mapper.toscientifique(sientreq);
		scientifiquesave.setDepartements(departement);;
		return repo.save(scientifiquesave).getId();
		
	}

}
