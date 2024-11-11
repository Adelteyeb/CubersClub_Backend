package com.CentreCulturel.demo.artiste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.membre.MembreRepository;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.membre.MembreService;
import com.CentreCulturel.demo.membre.MembreMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtisteServiceImpl implements ArtisteService {
	private final ArtisteRepository repo;
	private final ArtisteMapper mapper;

	@Override
	public Integer save(ArtisteRequest artreq) {
		// TODO Auto-generated method stub
		Artiste art =mapper.toartiste(artreq);
		return repo.save(art).getId();
	}

	@Override
	public ArtisteResponse findByID(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map( mapper::toartisteDTO).orElse(new ArtisteResponse()) ;
	}

	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.repo.deleteById(id);
		
	}

	@Override
	public ArtisteResponse findByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email).map(mapper::toartisteDTO).orElse(new ArtisteResponse());
	}
	
	@Override
	public List<ArtisteResponse> findAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll().stream().map(mapper::toartisteDTO)
				                           .collect(Collectors.toList());
		                          
	}

	@Override
	public List<ArtisteResponse> findByFirstNameAndLastName(String firstName, String LastName) {
		// TODO Auto-generated method stub
		 List<Artiste> artistes = repo.findByFirstNameAndLastName(firstName, LastName).orElse(Collections.EMPTY_LIST);
		    List<ArtisteResponse> artistesResponses = new ArrayList<>();

		    artistes.forEach(artiste->{ artistesResponses.add(mapper.toartisteDTO(artiste));});
	    return artistesResponses;
		

}
}