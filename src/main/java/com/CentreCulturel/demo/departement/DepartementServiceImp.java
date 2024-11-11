package com.CentreCulturel.demo.departement;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.administrateur.AdminRepository;
import com.CentreCulturel.demo.administrateur.Administrateur;
import com.CentreCulturel.demo.idee.Idee;
import com.CentreCulturel.demo.membre.MembreRepository;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.membre.MembreMapper;
import com.CentreCulturel.demo.message.Message;
import com.CentreCulturel.demo.message.MessageRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartementServiceImp implements DepartementService {
	private final DepartementRepository repo;
	private final DeptMapper mapper;
	private final MembreRepository utilrepo;
	private final MembreMapper utilmapper;
	private final MessageRepository messagerepo;
	
	@Autowired
	AdminRepository adminrepo;
    @Override
	public Integer save(DeptRequest dptreq) {
      Departement departement =mapper.todepartement(dptreq);
      departement.setAdministrateur(null);
      
		return repo.save(departement).getId();
	}

	@Override
	public DeptResponse findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(mapper::todepartementDTO)
				.orElse(new DeptResponse());
	}

	
	

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Administrateur admin=adminrepo.findAdminByDepartementId(id).orElse(new Administrateur());
		List<Membre> utilisateurs=utilrepo.findByDepartementId(id).orElse(Collections.EMPTY_LIST); 
		if(utilisateurs!=null) {
			for(Membre user : utilisateurs) {
				List<Message> messages =user.getMessages();
				if (messages != null && !messages.isEmpty()) {
			        for (Message message : messages) {
			            // Suppression de chaque message de la base de données.
			        	messagerepo.deleteById(message.getId());;
			        }
			        messages.clear(); // Supprime les messages de la collection en mémoire.
			    }
				utilrepo.deleteById(user.getId());
			}
			
		}
				
		List<Message> messages =admin.getMessages();
		if(admin.getMessages()!= null) {
		if (messages != null && !messages.isEmpty()) {
	        for (Message message : messages) {
	            // Suppression de chaque message de la base de données.
	        	messagerepo.deleteById(message.getId());
	        }
	        messages.clear(); // Supprime les messages de la collection en mémoire.
	    }
		}
		
		repo.deleteById(id);
		
	}

	@Override
	public void assignementDepartementToAdministrateur(Integer deptId, Integer adminId) {
		
		// TODO Auto-generated method stub
		Administrateur admin =adminrepo.findById(adminId).orElseThrow(()->new EntityNotFoundException("aministrateur n 'existe pas avec Id ::" +adminId));
		Departement departement=repo.findById(deptId).orElseThrow(()->new EntityNotFoundException("Departement n 'existe pas avec Id ::" +deptId));
		var dejaaffecte=Objects.equals(admin, departement.getAdministrateur()); 
		if(dejaaffecte) {
			throw new EntityNotFoundException("Departement deja Affectée"); 
		};
		 
		 admin.setDepartement(departement);
		 departement.setAdministrateur(admin);
		 repo.save(departement);
		 adminrepo.save(admin);
	}

	@Override
	public DeptResponse findDepartementByAdministraeurId(Integer id) {
		// TODO Auto-generated method stub
		return repo.findDepartementByAdministrateurId(id)
				.map(mapper::todepartementDTO).orElse(new DeptResponse());
	}

	@Override
	public void updateDepartementAdministrateur(Integer deptId, Integer adminId) {
	    // Récupérez l'administrateur et le département depuis leur ID
	    Administrateur admin = adminrepo.findById(adminId)
	            .orElseThrow(() -> new EntityNotFoundException("Administrateur n'existe pas avec l'ID :: " + adminId));
	    Departement departement = repo.findById(deptId)
	            .orElseThrow(() -> new EntityNotFoundException("Departement n'existe pas avec l'ID :: " + deptId));

	    // Vérifiez si le département est déjà associé à cet administrateur
	    

	    // Désaffectez le département actuel de l'administrateur, s'il existe
	    if (admin.getDepartement() != null) {
	        admin.setDepartement(null);
	    }
	    admin.setDepartement(departement);

	    // Associez le nouvel administrateur au département
	    departement.setAdministrateur(admin);

	    // Associez le département au nouvel administrateur
	   // admin.setDepartement(departement);

	    // Enregistrez les modifications dans la base de données
	    adminrepo.save(admin);
	    repo.save(departement);
	    
	}

	@Override
	public List<DeptResponse> findAllDepartements() {
		// TODO Auto-generated method stub
		return repo.findAll().stream().map(mapper::todepartementDTO).collect(Collectors.toList());
	}

	@Override
	public DeptResponse findByNameDepartement(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name).map(mapper::todepartementDTO).orElse(new DeptResponse());

	
	
	}

	@Override
	public Integer editeDepartement(DeptRequest dptreq) {
		// TODO Auto-generated method stub
		Departement departement = repo.findById(dptreq.getId())
	            .orElseThrow(() -> new EntityNotFoundException("Departement n'existe pas avec l'ID :: " + dptreq.getId()));
		    //departement.setId(2);
		   return   repo.save(departement).getId();
	}

	@Override
	public void assignementDepartementToutUtilisateur(Integer deptId, Integer utlitId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Membre util =utilrepo.findById(utlitId).orElseThrow(()->new EntityNotFoundException("aministrateur n 'existe pas avec Id ::" +utlitId));
				Departement departement=repo.findById(deptId).orElseThrow(()->new EntityNotFoundException("Departement n 'existe pas avec Id ::" +deptId));
				
				 
				 util.setDepartement(departement);
				 departement.getListUtilisateur().add(util);
				 repo.save(departement);
				 utilrepo.save(util);
	}

	@Override
	public void updateDepartementUtilisateur(Integer idu, Integer iddnew,Integer iddanc) {
		 Membre util = utilrepo.findById(idu)
		            .orElseThrow(() -> new EntityNotFoundException("Utilisateur n'existe pas avec l'ID :: " + idu));
		    Departement departement = repo.findById(iddnew)
		            .orElseThrow(() -> new EntityNotFoundException("Departement n'existe pas avec l'ID :: " + iddnew));
		    Departement ancdepartement = repo.findById(iddanc)
		            .orElseThrow(() -> new EntityNotFoundException("Departement n'existe pas avec l'ID :: " + iddanc));
		    ancdepartement.getListUtilisateur().remove(util);
		    departement.getListUtilisateur().add(util);
		    util.setDepartement(departement);
		    utilrepo.save(util);
		    repo.save(departement);
		
	}

	@Override
	public DeptResponse findDepartementByutilisateursId(Integer id) {
		// TODO Auto-generated method stub
		Membre util =utilrepo.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Utilisateur Non trouvé"));
		DeptResponse departementResponse =mapper.todepartementDTO(util.getDepartement());
		return departementResponse ;
	}

}
