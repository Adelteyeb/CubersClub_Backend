package com.CentreCulturel.demo.formateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.membre.MembreRepository;
import com.CentreCulturel.demo.membre.MembreMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class FormateurServiceImp implements FormateurService {
	private final FormateurRepository repo;
	private final FormateurMapper mapper;
	@Override
	public Integer save(FormateurRequest formreq) {
		// TODO Auto-generated method stub
		Formateur form =mapper.toformateur(formreq);
		return repo.save(form).getId();
	}

	@Override
	public FormateurResponse findByID(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(mapper:: toformateurDTO).orElse(new FormateurResponse());
	}

	@Override
	public List<FormateurResponse> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll().stream().map(mapper::toformateurDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public FormateurResponse findByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email).map(mapper::toformateurDTO).orElse(new FormateurResponse());
	}

	@Override
	public List<FormateurResponse> findByFirstNameAndLastName(String firstName, String LastName) {
		// TODO Auto-generated method stub
		List<FormateurResponse> formateurresponses=new ArrayList<>();
		List<Formateur> formateurs =repo.findByFirstNameAndLastName(firstName, LastName).orElse(Collections.EMPTY_LIST);
		formateurs.forEach(formateur->{formateurresponses.add(mapper.toformateurDTO(formateur));});
		return formateurresponses;
	}

}
