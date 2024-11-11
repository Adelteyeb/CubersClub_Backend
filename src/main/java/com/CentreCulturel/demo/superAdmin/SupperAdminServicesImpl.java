package com.CentreCulturel.demo.superAdmin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.membre.MembreRepository;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreMapper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@Service
@RequiredArgsConstructor
public class SupperAdminServicesImpl implements SupperAdminservices {
	private final SupperAdminRepository repo;
	private final SupperAdminMapper mapper;
	@Override
	public Integer save(SupperAdminRequest adminreq) {
		
		SupperAdmin supper =mapper.tosupperadmin(adminreq);
		//supper.setRole("SUPER");
		return repo.save(supper).getId();
	}

	@Override
	public SupperAdminResponse findByID(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(mapper :: tosuperadminDTO).orElse(new SupperAdminResponse());
	}

	@Override
	public List<SupperAdminResponse> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll().stream().map(mapper :: tosuperadminDTO)
				.collect(Collectors
						.toList());
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public SupperAdminResponse findByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email).map(mapper :: tosuperadminDTO).orElse(new SupperAdminResponse());
	}

	@Override
	public List<SupperAdminResponse> findByFirstNameAndLastName(String firstName, String LastName) {
		// TODO Auto-generated method stub
		List<SupperAdmin> supperadmins =repo.findByFirstNameAndLastName(firstName, LastName).orElse(Collections.EMPTY_LIST);
		List<SupperAdminResponse> supperadminresponses =new ArrayList<>();
		supperadmins.forEach(admin->{ supperadminresponses.add(mapper.tosuperadminDTO(admin));});
		return supperadminresponses;
	}

	@Override
	public Integer edit(SupperAdminRequest superRequest) {
		// TODO Auto-generated method stub
		SupperAdmin supperadmin=repo.findById(superRequest.getId()).orElse(new SupperAdmin());
		//supperadmin.setRole("SUPER");
		SupperAdmin supperadminesdit =mapper.tosupperadmin(superRequest);
		return repo.save(supperadminesdit).getId();
	}

	

}
