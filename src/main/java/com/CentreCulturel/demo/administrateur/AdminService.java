package com.CentreCulturel.demo.administrateur;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.superAdmin.SupperAdminRequest;

public interface AdminService {
	Integer save(AdminRequest adminreq);
	AdminResponse findByID(Integer id);
	List<AdminResponse> findAll();
	void delete(Integer id);
	AdminResponse findByEmail(String email);
	List<AdminResponse> findByFirstNameAndLastName(String firstName, String LastName);
	AdminResponse findAdminDepartement(Integer id);
	Integer edit(AdminRequest adminrequest);

}
