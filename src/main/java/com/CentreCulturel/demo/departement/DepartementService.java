package com.CentreCulturel.demo.departement;
import java.util.List;

import com.CentreCulturel.demo.membre.MembreResponse;
public interface DepartementService {
	Integer save(DeptRequest dptreq);
	DeptResponse findById(Integer id);
	DeptResponse findByNameDepartement(String name);
	List<DeptResponse> findAllDepartements();
	void delete(Integer id);
	DeptResponse findDepartementByAdministraeurId(Integer id);
	void assignementDepartementToAdministrateur(Integer deptId , Integer adminId);
	void updateDepartementAdministrateur(Integer deptId,Integer adminId);
	Integer editeDepartement(DeptRequest dptreq);
	void assignementDepartementToutUtilisateur(Integer deptId , Integer utlitId);
	void updateDepartementUtilisateur(Integer idu, Integer iddn,Integer iddanc);
	DeptResponse findDepartementByutilisateursId(Integer id);
	
	
}
