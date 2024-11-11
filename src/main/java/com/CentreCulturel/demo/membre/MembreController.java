package com.CentreCulturel.demo.membre;

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
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.CentreCulturel.demo.administrateur.AdminRequest;
import com.CentreCulturel.demo.user.UserResponse;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Utilisateurs")
public class MembreController {
	//@Autowired
	private final MembreServiceImpl service;
	@PostMapping("/{id_dept}")
	public ResponseEntity<Integer> save( @RequestBody
			@Valid MembreRequest utlisreq, @PathVariable(value="id_dept") Integer dept_id){
		      //utlisreq.setRole("UTIL");
		
		
				return ResponseEntity
						.accepted()
						.body(this.service.save(utlisreq,dept_id));
		
	}
	@GetMapping("/{utili-id}")
	public ResponseEntity<MembreResponse> findById(@PathVariable("utili-id") Integer id){
		return ResponseEntity.ok(service.findByID(id));
	}
	
    @GetMapping(value="/ALL")
    public ResponseEntity<List<MembreResponse>> findAll(){
    	return ResponseEntity.ok(service.findAll());
    	
    }
    @GetMapping("Evenement/{id}")
    public ResponseEntity<List<MembreResponse>> findMenbreByEventScient(@PathVariable(value="id") Integer event_id){
    	return ResponseEntity.ok(service.findListmembreByEventScient(event_id));
    	
    }
     @GetMapping({"/email/email"})
    public ResponseEntity<MembreResponse> findByEmail(@RequestParam("email") String email){
    	return ResponseEntity.ok(service.findByEmail(email));
    }
     
    @GetMapping("/search")
    public ResponseEntity<List<MembreResponse>> findByFirstNameAndLastname(@RequestParam(value = "firstName")String firstName ,
    		@RequestParam(value = "lastName")String lastName){
		return ResponseEntity.ok(service.findByFirstNameAndLastName(firstName, lastName));
    	
    }
    @DeleteMapping("/{utilis-id}")
    public ResponseEntity<Void> delete(@PathVariable("utilis-id") Integer id){
    	service.delete(id);
		return ResponseEntity.ok().build();
    	
    }
    @GetMapping("/Departement/{id}")
    public ResponseEntity<List<MembreResponse>> finListUtilisateursResponse( @PathVariable("id") Integer id,Integer id_dept){
    	return ResponseEntity.ok(service.findByDepartementId(id));
    }
    @PutMapping("/update/{id_dept}")
	 ResponseEntity<Integer> updateUser(@RequestBody
	 		                             @Valid  MembreRequest userReq, @PathVariable(value = "id_dept") Integer dept_id){
	 	return ResponseEntity.accepted().body(service.edit(userReq,dept_id));
	 }
   
}
