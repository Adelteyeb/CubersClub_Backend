package com.CentreCulturel.demo.idee;

import java.util.List;

import com.CentreCulturel.demo.departement.DeptRequest;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreRequest;

public interface IdeeServices {
	Integer save(IdeeRequest idreq,Integer id);
	IdeeResponse findById(Integer id);
	List<IdeeResponse> findAll();
	void delete(Integer id);
	List<IdeeResponse> findAllIdeeUtil(Integer id);
	void assignementIdeeToUtilisateur(Integer utiliId , Integer ideeId);
	Integer editeIdee(IdeeRequest idreq,Integer user_id);
}
