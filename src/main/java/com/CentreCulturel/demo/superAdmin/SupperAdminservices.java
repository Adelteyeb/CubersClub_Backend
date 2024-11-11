package com.CentreCulturel.demo.superAdmin;

import java.util.List;

import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreResponse;

public interface SupperAdminservices {
	Integer save(SupperAdminRequest utilsreq);
	SupperAdminResponse findByID(Integer id);
	List<SupperAdminResponse> findAll();
	void delete(Integer id);
	SupperAdminResponse findByEmail(String email);
	List<SupperAdminResponse> findByFirstNameAndLastName(String firstName, String LastName);
	Integer edit(SupperAdminRequest superequest);
	
}
