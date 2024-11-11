package com.CentreCulturel.demo.administrateur;

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

import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.superAdmin.SupperAdminRequest;
import com.CentreCulturel.demo.superAdmin.SupperAdminServicesImpl;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Administrateurs")
@RequiredArgsConstructor
public class AdminController {
	private final AdmiServiceImpl service;
	@PostMapping
	public ResponseEntity<Integer> save( @RequestBody @Valid AdminRequest adminreq){
		adminreq.setRole("ADMIN");
		return ResponseEntity
				.accepted()
				.body(this.service.save(adminreq));
	}
	@GetMapping("/{admin-id}")
	public ResponseEntity<AdminResponse> findByid(@PathVariable(value = "admin-id") Integer id){
		return ResponseEntity.ok(service.findByID(id));
	}
	 @GetMapping("/ALL")
	    public ResponseEntity<List<AdminResponse>> findAll(){
	    	return ResponseEntity.ok(service.findAll());
	    	
	    }
	 @GetMapping({"/email/email"})
	    public ResponseEntity<AdminResponse> findByEmail(@RequestParam("email") String email){
	    	return ResponseEntity.ok(service.findByEmail(email));
	    }
	 @GetMapping("/search")
	    public ResponseEntity<List<AdminResponse>> findByFirstNameAndLastname(@RequestParam(value = "firstName")String firstName ,
	    		@RequestParam(value = "lastName")String lastName){
			return ResponseEntity.ok(service.findByFirstNameAndLastName(firstName, lastName));
	    	
	    }
	 @DeleteMapping("/{admin-id}")
	    public ResponseEntity<Void> delete(@PathVariable("admin-id") Integer id){
	    	service.delete(id);
			return ResponseEntity.ok().build();
	    	
	    }
	
	 @GetMapping("/Administrateur/Departement/{id}")
	public ResponseEntity<AdminResponse> getAdminDepartemnt(@PathVariable("id") Integer id){
		 return ResponseEntity.ok(service.findAdminDepartement(id));
	 }
	 @PutMapping("/update")
	 ResponseEntity<Integer> updateAdmin(@RequestBody
	 		                             @Valid  AdminRequest adminReq){
	 	return ResponseEntity.accepted().body(service.edit(adminReq));
	 }
}
