package com.CentreCulturel.demo.formateur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.membre.MembreServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Formateurs")
public class FormateurController {
	@Autowired
	private FormateurServiceImp service;
	@PostMapping
	public ResponseEntity<Integer> save( @RequestBody
			@Valid FormateurRequest formreq){
				return ResponseEntity
						.accepted()
						.body(this.service.save(formreq));
		
	}
	@GetMapping("/{form-id}")
	public ResponseEntity<FormateurResponse> findById(@PathVariable("form-id") Integer id){
		return ResponseEntity.ok(service.findByID(id));
	}
	
    @GetMapping("/ALL")
    public ResponseEntity<List<FormateurResponse>> findAll(){
    	return ResponseEntity.ok(service.findAll());
    	
    }
     @GetMapping({"/email/email"})
    public ResponseEntity<FormateurResponse> findByEmail(@RequestParam("email") String email){
    	return ResponseEntity.ok(service.findByEmail(email));
    }
     
    @GetMapping("/search")
    public ResponseEntity<List<FormateurResponse>> findByFirstNameAndLastname(@RequestParam(value = "firstName")String firstName ,
    		@RequestParam(value = "lastName")String lastName){
		return ResponseEntity.ok(service.findByFirstNameAndLastName(firstName, lastName));
    	
    }
    @DeleteMapping("/{form-id}")
    public ResponseEntity<Void> delete(@PathVariable("form-id") Integer id){
    	service.delete(id);
		return ResponseEntity.ok().build();
    	
    }
}
