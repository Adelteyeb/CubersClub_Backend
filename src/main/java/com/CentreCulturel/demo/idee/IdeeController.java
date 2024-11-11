package com.CentreCulturel.demo.idee;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CentreCulturel.demo.membre.MembreRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Idees")
public class IdeeController {
	private final IdeeServiceImpl service;
	@PostMapping("/Utilisateur/{user_id}")
	public ResponseEntity<Integer> save(@RequestBody @Valid IdeeRequest ideereq, 
			                           @PathVariable(value="user_id") Integer id){
		return ResponseEntity
				.accepted()
				.body(service.save(ideereq,id));
		
	}
	@GetMapping("/All")
	public ResponseEntity<List<IdeeResponse>> findAll(){
		return ResponseEntity
				.ok(service.findAll());
	}
	@GetMapping("/{idee-id}")
	public ResponseEntity<IdeeResponse> findById(@PathVariable(value = "idee-id") Integer id){
        return ResponseEntity.ok(service.findById(id));
    }
	@GetMapping("idees/utilisateur/{util_id}")
	public ResponseEntity<List<IdeeResponse>> findIdeeByUtilisateur(@PathVariable("util_id") Integer id){
		return ResponseEntity
				.ok(service.findAllIdeeUtil(id));
	}
	@PostMapping("utilisateur/{util-id}/idee/{idee-id}")
	public ResponseEntity<Void> AssignementIdeeToUtilisateur(@PathVariable(value="util-id")Integer id,@PathVariable(value = "idee-id") Integer idd) {
		service.assignementIdeeToUtilisateur(id, idd);
		
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/delete/{idee-id}")
	public ResponseEntity<Void>delete(@PathVariable("idee-id") Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	@PutMapping("/update/Utilisateur/{user_id}")
	public ResponseEntity<Integer> updateIdeeuser(@RequestBody IdeeRequest ideereq, @PathVariable(value="user_id")  Integer id){
		return ResponseEntity.ok(service.editeIdee(ideereq, id));
	}
	
}
