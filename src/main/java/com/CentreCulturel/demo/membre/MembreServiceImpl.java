package com.CentreCulturel.demo.membre;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.sql.model.ast.builder.CollectionRowDeleteByUpdateSetNullBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.administrateur.Administrateur;
import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.departement.DepartementRepository;
import com.CentreCulturel.demo.message.Message;
import com.CentreCulturel.demo.message.MessageRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MembreServiceImpl implements MembreService {
	private final MembreRepository repo;
	private final MembreMapper mapper;
	private final DepartementRepository deptrepo;
	private final MessageRepository messagerepo;
	@Override
	public Integer save(MembreRequest utilsreq,Integer dept_id) {
		Departement departement =deptrepo.findById(dept_id).orElse(new Departement());
	
		Membre util =mapper.toututilisateur(utilsreq);
		
		util.setDepartement(departement);
		departement.getListUtilisateur().add(util);
		deptrepo.save(departement);
		return repo.save(util).getId();
	}

	@Override
	public MembreResponse findByID(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map( mapper::toutlisateurDTO).orElse(new MembreResponse()) ;
	}

	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Membre utilisateur=repo.findById(id).orElse(new Membre());
		List<Message> messages =utilisateur.getMessages();
		if (messages != null && !messages.isEmpty()) {
	        for (Message message : messages) {
	            // Suppression de chaque message de la base de données.
	        	messagerepo.deleteById(message.getId());;
	        }
	        messages.clear(); // Supprime les messages de la collection en mémoire.
	    }
		this.repo.deleteById(id);
		//repo.save(utilisateur);
		
	}

	@Override
	public MembreResponse findByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email).map(mapper::toutlisateurDTO).orElse(new MembreResponse());
	}
	
	@Override
	public List<MembreResponse> findAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll().stream().map(mapper::toutlisateurDTO)
				                           .collect(Collectors.toList());
		                          
	}

	@Override
	public List<MembreResponse> findByFirstNameAndLastName(String firstName, String LastName) {
		// TODO Auto-generated method stub
		 List<Membre> utilisateurs = repo.findByFirstNameAndLastName(firstName, LastName).orElse(Collections.EMPTY_LIST);
		    List<MembreResponse> utilisateurResponses = new ArrayList<>();

		    utilisateurs.forEach(utilisateur->{ utilisateurResponses.add(mapper.toutlisateurDTO(utilisateur));});
	    return utilisateurResponses;
		/*return repo.findByFirstNameAndLastName(firstName, LastName).stream()
				.map(mapper::toutlisateurDTO)
				.collect(Collectors.toList())
				.orElse( Collections.emptyList());*/
	}

	@Override
	public List<MembreResponse> findByDepartementId(Integer id) {
		 List<Membre> utilisateurs = repo.findByDepartementId(id).orElse(Collections.EMPTY_LIST);
		 List<MembreResponse> utilisateurResponses = new ArrayList<>();
		 utilisateurs.forEach(utilisateur->{ utilisateurResponses.add(mapper.toutlisateurDTO(utilisateur));});
		    return utilisateurResponses;
		
	}

	@Override
	public List<MembreResponse> findListmembreByEventScient(Integer event_id) {
		// TODO Auto-generated method stub
		List<Membre> utilisateurs = repo.findByEvenementsId(event_id).orElse(Collections.EMPTY_LIST);
		 List<MembreResponse> utilisateurResponses = new ArrayList<>();
		 utilisateurs.forEach(utilisateur->{ utilisateurResponses.add(mapper.toutlisateurDTO(utilisateur));});
		    return utilisateurResponses;
	}

	@Override
	public Integer edit(MembreRequest utilrequest,Integer dept_id) {
		Membre user=repo.findById(utilrequest.getId()).orElse(new Membre());
		//supperadmin.setRole("SUPER");
		Departement departement =deptrepo.findById(dept_id).orElse(new Departement());
		Membre useredit =mapper.toututilisateur(utilrequest);
		useredit.setDepartement(departement);
		return repo.save(useredit).getId();
	}

	

}
