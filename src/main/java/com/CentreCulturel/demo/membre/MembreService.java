package com.CentreCulturel.demo.membre;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.CentreCulturel.demo.administrateur.AdminRequest;
import com.CentreCulturel.demo.administrateur.AdminResponse;

public interface MembreService {
	Integer save(MembreRequest utilsreq,Integer dept_id);
	MembreResponse findByID(Integer id);
	List<MembreResponse> findAll();
	void delete(Integer id);
	MembreResponse findByEmail(String email);
	List<MembreResponse> findByFirstNameAndLastName(String firstName, String LastName);
	List<MembreResponse> findByDepartementId(Integer id);
	List<MembreResponse> findListmembreByEventScient(Integer event_id);
	Integer edit(MembreRequest utilrequest,Integer dept_id);

}
