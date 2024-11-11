package com.CentreCulturel.demo.departement;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CentreCulturel.demo.idee.IdeeResponse;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Departements")
public class DepartementController {
	private final DepartementServiceImp service;
	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody @Valid DeptRequest deptreq) {
		
		return ResponseEntity.accepted().body(service.save(deptreq)); 
	}
	@GetMapping("/{dept_id}")
	public ResponseEntity<DeptResponse> findById(@PathVariable(value = "dept_id") Integer id){
		return ResponseEntity.ok(service.findById(id));
	}
	@GetMapping("/All")
	public ResponseEntity<List<DeptResponse>> findallDepartement(){
		return ResponseEntity.ok(service.findAllDepartements());
	}
	@GetMapping("/sarchByName")
	public ResponseEntity<DeptResponse> SearchByname(@RequestParam(value = "name") String name){
		return ResponseEntity.ok(service.findByNameDepartement(name));
	}
	@GetMapping("Departement/Administrateur/{admin_id}")
	public ResponseEntity<DeptResponse> findDepartementbyAdmin(@PathVariable("admin_id") Integer id){
		return ResponseEntity
				.ok(service.findDepartementByAdministraeurId(id));
	}
	@PostMapping("Departement/{dept-id}/Administrateur/{admin-id}")
	public ResponseEntity<Void> AssignementDepartementAdministrateur(@PathVariable(value="dept-id")Integer idd,@PathVariable(value = "admin-id") Integer id) {
		service.assignementDepartementToAdministrateur(idd, id);
		
		return ResponseEntity.ok().build();
	}
	@PostMapping("Departement/{dept-id}/NewAdministrateur/{admin-id}")
	public ResponseEntity<Void> updateDepartementAdministrateur(@PathVariable(value="dept-id")Integer idd,@PathVariable(value = "admin-id") Integer id) {
		service.updateDepartementAdministrateur(idd, id);
		
		return ResponseEntity.ok().build();
	}
	@PutMapping("/update")
	public ResponseEntity<Integer> updateDepartement(@RequestBody @ Valid DeptRequest deptreq){
		return ResponseEntity.accepted().body(service.editeDepartement(deptreq));
	}
	 @PostMapping("/Departement/{dept-id}/Utilisateur/{utilt-id}")
	 public ResponseEntity<Void> assigneUtilisateurToDepartement(@PathVariable(value="utilt-id")Integer idd,@PathVariable(value = "dept-id") Integer idu) {
			service.assignementDepartementToutUtilisateur(idu, idd);
			
			return ResponseEntity.ok().build();
		}
	 @PostMapping("Utilisateur/{idu}/NewDepartement/{iddnew}/AncienDepartemnt/{iddanc}")
	 public ResponseEntity<Void> updateDepartementUtilisateur(@PathVariable(value="idu") Integer id_ut,@PathVariable(value="iddnew") Integer id_new,@PathVariable(value="iddanc") Integer id_ancien){
		 service.updateDepartementUtilisateur(id_ut, id_new, id_ancien);
		 
		 return ResponseEntity.ok().build();
	 }
	 @GetMapping("/Utilsateurs/{idu}")
	 public ResponseEntity<DeptResponse> findDepartementUtil
	                           (@PathVariable(value="idu") Integer id){
		 return ResponseEntity.ok(service.findDepartementByutilisateursId(id));
	 }
	 @DeleteMapping("/{dept-id}")
	    public ResponseEntity<Void> delete(@PathVariable("dept-id") Integer id){
	    	service.delete(id);
			return ResponseEntity.ok().build();
	    	
	    }
	}
	


