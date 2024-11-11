package com.CentreCulturel.demo.idee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.membre.MembreRepository;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class IdeeServiceImpl implements IdeeServices {
private final IdeeRepository repo;
private final IdeeMapper mapper;
private final MembreRepository utilrepo;
private final MembreMapper utilmapper;

	@Override
	public Integer save(IdeeRequest idreq, Integer id) {
		// TODO Auto-generated method stub
		Membre user=utilrepo.findById(id).orElseThrow(()->new EntityNotFoundException("Utilisateur  n exista pas"));
		Idee idee=mapper.toidee(idreq);
		idee.setUtilisateur(user);
		user.getIdes().add(idee);
		utilrepo.save(user);
		return repo.save(idee).getId();
	}

	@Override
	public IdeeResponse findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(mapper::toideeDTO).orElse(new IdeeResponse());
	}

	@Override
	public List<IdeeResponse> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll().stream()
				.map(mapper :: toideeDTO)
				.collect(Collectors
						.toList());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<IdeeResponse> findAllIdeeUtil(Integer id) {
		// TODO Auto-generated method stub
		List<IdeeResponse> ideeresponses =new ArrayList<>();
		//Utilisateur util=utilmapper.toututilisateur(utilreq);
		List <Idee> idess=repo.findIdeeByUtilisateurId(id).orElse(Collections.EMPTY_LIST);
		idess.forEach(idee->{ideeresponses.add(mapper.toideeDTO(idee));});
		return ideeresponses;
	}

	@Override
	public void assignementIdeeToUtilisateur(Integer utiliId, Integer ideeId) {
		// TODO Auto-generated method stub
		Membre utilisateur =utilrepo.findById(utiliId).orElseThrow(()->new EntityNotFoundException("Utlisateur n existe pas avec Id ::" +ideeId));
		var dejaaffecte =utilisateur.getIdes()
				.stream()
				.map(Idee::getId)
				.anyMatch(id->Objects.equals(id, utilisateur.getId()));
		if(dejaaffecte) {
			throw new EntityNotFoundException("Idee deja Affectée"); 
		};
		 Idee idee =repo.findById(ideeId).orElseThrow(()-> new EntityNotFoundException("Idee non trouvée ::"+ideeId));
		 utilisateur.getIdes().add(idee);
		 idee.setUtilisateur(utilisateur);
		 repo.save(idee);
		 utilrepo.save(utilisateur);
		
	}

	@Override
	public Integer editeIdee(IdeeRequest ideereq, Integer user_id) {
		// TODO Auto-generated method stub
		Idee idee =repo.findById(ideereq.getId())
				.orElseThrow(()-> new EntityNotFoundException("Idee n existe pas avec L Id" + ideereq.getId()));
		Membre utlisateur =utilrepo.findById(user_id)
				.orElseThrow(()-> new EntityNotFoundException("Utlisateur n existe pas avec L Id" + user_id));
		
		Idee   ideesave =mapper.toidee(ideereq);
		ideesave.setUtilisateur(utlisateur);
		return repo.save(ideesave).getId();
	}

	

}
