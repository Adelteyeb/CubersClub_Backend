package com.CentreCulturel.demo.artiste;

import java.util.List;

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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Artistes")
@RequiredArgsConstructor
public class ArtisteController {
	private final ArtisteServiceImpl service;
	@PostMapping
	public ResponseEntity<Integer> save( @RequestBody
			@Valid ArtisteRequest artreq){
				return ResponseEntity
						.accepted()
						.body(this.service.save(artreq));
		
	}
	@GetMapping("/{art-id}")
	public ResponseEntity<ArtisteResponse> findById(@PathVariable("art-id") Integer id){
		return ResponseEntity.ok(service.findByID(id));
	}
	
    @GetMapping("/ALL")
    public ResponseEntity<List<ArtisteResponse>> findAll(){
    	return ResponseEntity.ok(service.findAll());
    	
    }
    @GetMapping({"/email/email"})
    public ResponseEntity<ArtisteResponse> findByEmail(@RequestParam("email") String email){
    	return ResponseEntity.ok(service.findByEmail(email));
    }
     
    @GetMapping("/search")
    public ResponseEntity<List<ArtisteResponse>> findByFirstNameAndLastname(@RequestParam(value = "firstName")String firstName ,
    		@RequestParam(value = "lastName")String lastName){
		return ResponseEntity.ok(service.findByFirstNameAndLastName(firstName, lastName));
    	
    }
    @DeleteMapping("/{art-id}")
    public ResponseEntity<Void> delete(@PathVariable("art-id") Integer id){
    	service.delete(id);
		return ResponseEntity.ok().build();
    	
    }
}
