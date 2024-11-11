package com.CentreCulturel.demo.superAdmin;

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

import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreResponse;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RestController
@RequiredArgsConstructor
@RequestMapping("/SupperAdmins")
public class SupperAdminController {
private final SupperAdminServicesImpl service;
@PostMapping
public ResponseEntity<Integer> save( @RequestBody
		@Valid SupperAdminRequest supreq){
	     //supreq.setRole("SUPER");
			return ResponseEntity
					.accepted()
					.body(this.service.save(supreq));
	
}
@GetMapping("/{suppadmin-id}")
public ResponseEntity<SupperAdminResponse> findById(@PathVariable("suppadmin-id") Integer id){
	return ResponseEntity.ok(service.findByID(id));
}
@GetMapping("/ALL")
public ResponseEntity<List<SupperAdminResponse>> findAll(){
	return ResponseEntity.ok(service.findAll());
	
}
@GetMapping({"/email/email"})
public ResponseEntity<SupperAdminResponse> findByEmail(@RequestParam("email") String email){
	return ResponseEntity.ok(service.findByEmail(email));
}
@GetMapping("/search")
public ResponseEntity<List<SupperAdminResponse>> findByFirstNameAndLastname(@RequestParam(value = "firstName")String firstName ,
		@RequestParam(value = "lastName")String lastName){
	return ResponseEntity.ok(service.findByFirstNameAndLastName(firstName, lastName));
	
}
@DeleteMapping("/{suppadmin-id}")
public ResponseEntity<Void> delete(@PathVariable("suppadmin-id") Integer id){
	service.delete(id);
	return ResponseEntity.ok().build();
	
}
@PutMapping("/update")
ResponseEntity<Integer> updateSupperAdmin(@RequestBody
		                             @Valid  SupperAdminRequest supReq){
	return ResponseEntity.accepted().body(service.edit(supReq));
}
}
