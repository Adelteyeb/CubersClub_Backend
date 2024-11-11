package com.CentreCulturel.demo.administrateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.departement.DepartementRepository;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.message.Message;
import com.CentreCulturel.demo.message.MessageRepository;
import com.CentreCulturel.demo.superAdmin.SupperAdmin;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@Service
@RequiredArgsConstructor
public class AdmiServiceImpl implements AdminService {
private final AdminRepository repo;
private final AdminMapper mapper;
private final DepartementRepository deptrepo;
private final MessageRepository messagerepo;
	@Override
	public Integer save(AdminRequest adminreq) {
		// TODO Auto-generated method stub
		Administrateur administrateur=mapper.toadministrateur(adminreq);
		return repo.save(administrateur).getId();
	}

	@Override
	public AdminResponse findByID(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(mapper::toadmistrateurDTO).orElse(new AdminResponse());
	}

	@Override
	public List<AdminResponse> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll().stream().map(mapper::toadmistrateurDTO).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		Departement departement=deptrepo.findDepartementByAdministrateurId(id).orElse(new Departement());
		// TODO Auto-generated method stub
		
		Administrateur admin= repo.findById(id).orElse(new Administrateur());
		
		/*if(departement!=null) {
			
			//admin.getMessages().removeAll(null);
			List<Message> messages =admin.getMessages();
			if (messages != null && !messages.isEmpty()) {
		        for (Message message : messages) {
		            // Suppression de chaque message de la base de données.
		        	messagerepo.deleteById(message.getId());
		        }
		        messages.clear(); // Supprime les messages de la collection en mémoire.
		    }
		
		}*/
		departement.setAdministrateur(null);
		//deptrepo.save(departement);
		repo.deleteById(id);
		
	}

	@Override
	public AdminResponse findByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByemail(email).map(mapper::toadmistrateurDTO).orElse(new AdminResponse());
	}

	@Override
	public List<AdminResponse> findByFirstNameAndLastName(String firstName, String LastName) {
		// TODO Auto-generated method stub
		List <Administrateur> administrateurs =new ArrayList<>();
		List<AdminResponse> adminresponses= new ArrayList<>();
		administrateurs=repo.findByFirstNameAndLastName(firstName, LastName).orElse(Collections.EMPTY_LIST);
		administrateurs.forEach(administrateur->{adminresponses.add(mapper.toadmistrateurDTO(administrateur));});
			
		
		return adminresponses;
	}

	@Override
	public AdminResponse findAdminDepartement(Integer id) {
		// TODO Auto-generated method stub
		return mapper.toadmistrateurDTO(repo.findAdminByDepartementId(id).orElseThrow(()-> new EntityNotFoundException("not found")));
	}

	@Override
	public Integer edit(AdminRequest adminRequest) {
		// TODO Auto-generated method stub
				Administrateur admin=repo.findById(adminRequest.getId()).orElse(new Administrateur());
				//supperadmin.setRole("SUPER");
				Administrateur adminesdit =mapper.toadministrateur(adminRequest);
				return repo.save(adminesdit).getId();
	}

	

}
