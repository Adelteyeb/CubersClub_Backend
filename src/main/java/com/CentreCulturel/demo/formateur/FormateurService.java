package com.CentreCulturel.demo.formateur;

import java.util.List;

import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreResponse;

public interface FormateurService {
	Integer save(FormateurRequest formreq);
	FormateurResponse findByID(Integer id);
	List<FormateurResponse> findAll();
	void delete(Integer id);
	FormateurResponse findByEmail(String email);
	List<FormateurResponse> findByFirstNameAndLastName(String firstName, String LastName);
}
