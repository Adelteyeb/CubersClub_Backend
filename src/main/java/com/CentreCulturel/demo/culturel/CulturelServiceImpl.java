package com.CentreCulturel.demo.culturel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.departement.DepartementRepository;
import com.CentreCulturel.demo.evenementscientifique.Scientifique;
import com.CentreCulturel.demo.evenementscientifique.ScientifiqueResponse;
import com.CentreCulturel.demo.membre.MembreRepository;
import com.CentreCulturel.demo.membre.Membre;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CulturelServiceImpl implements CulturelService {
	private final CulturelRepository repo;
	private final CulturelMapper mapper;
	private final DepartementRepository deptrepo;
	private final MembreRepository utilirepo;
	@Override
	public Integer save(CulturelRequest cult,Integer id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
Departement departement =deptrepo.findById(id).orElse(new Departement());
		
		Culturel culturel =mapper.toCulturel(cult);
		culturel.setDepartements(departement);
		
		return repo.save(culturel).getId();
	}

	@Override
	public CulturelResponse findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(mapper::toculturelDTO).orElse(new CulturelResponse());
	}

	@Override
	public List<CulturelResponse> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll().stream()
				             .map(mapper::toculturelDTO)
				             .collect(Collectors.toList());
	}

	@Override
	public CulturelResponse findByDateCreation(LocalDate date) {
		// TODO Auto-generated method stub
		return repo.findByDateCreation(date).map(mapper::toculturelDTO).orElse(new CulturelResponse());
	}

	@Override
	public void deleteById(Integer id) {
		Culturel culturel = repo.findById(id).orElse(new Culturel());
        if (culturel !=null) {
            
            // Remove the event from all users
            for (Membre user : culturel.getListUtilisateur()) {
                user.getEvenements().remove(culturel);
                utilirepo.save(user);
                culturel.getListUtilisateur().remove(user);
                
                
            }
        }
            
            // Now delete the event
		
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<CulturelResponse> findEventCulturelByDepartementId(Integer id) {
		List<Culturel> culturels = repo.findEventCulturelByDepartementsId(id).orElse(Collections.EMPTY_LIST);
	    List<CulturelResponse> culturelResponses = new ArrayList<>();

	    culturels.forEach(event->{ culturelResponses.add(mapper.toculturelDTO(event));});
    return culturelResponses;
		
	}

	@Override
	public void assignementUserToEventCulturel(Integer eventId, Integer userId) {
		Membre util =utilirepo.findById(userId).orElseThrow(()->new EntityNotFoundException("membre n 'existe pas avec Id ::" +userId));
		Culturel culturel=repo.findById(eventId).orElseThrow(()->new EntityNotFoundException("Evenement n 'existe pas avec Id ::" +eventId));
		
		 
		 util.getEvenements().add(culturel);
		 culturel.getListUtilisateur().add(util);
		 repo.save(culturel);
		 utilirepo.save(util);
		
	}

	@Override
	public List<CulturelResponse> ListEventByUtilisateur(Integer id) {
		List<Culturel> culturels = repo.findEventCulturelByListUtilisateurId(id).orElse(Collections.EMPTY_LIST);
	    List<CulturelResponse> culturelResponses = new ArrayList<>();

	    culturels.forEach(event->{ culturelResponses.add(mapper.toculturelDTO(event));});
    return culturelResponses;
		
	}

	@Override
	public Integer edit(CulturelRequest cultreq, Integer id) {
		Culturel culturel =repo.findById(cultreq.getId())
				.orElseThrow(()-> new EntityNotFoundException("Event n existe pas avec L Id" + cultreq.getId()));
		Departement departement =deptrepo.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Departemnt n existe pas avec L Id" + id));
		
		Culturel   culturelsave =mapper.toCulturel(cultreq);
		culturelsave.setDepartements(departement);;
		return repo.save(culturelsave).getId();
	}

}
