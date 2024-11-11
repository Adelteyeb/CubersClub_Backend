package com.CentreCulturel.demo.departement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.administrateur.Administrateur;
import com.CentreCulturel.demo.membre.Membre;

import jakarta.validation.constraints.NotNull;
@Service
public class DeptMapper {
	public Departement todepartement(DeptRequest deptReq) {
		return Departement.builder()
				.id(deptReq.getId())
				.name(deptReq.getName())
				.description(deptReq.getDescription())
				 
				.build();
	}
	public DeptResponse todepartementDTO(Departement dept) {
		return DeptResponse.builder()
				.id(dept.getId())
				.name(dept.getName())
				.description(dept.getDescription())
				.build();
	}
	
	
}
