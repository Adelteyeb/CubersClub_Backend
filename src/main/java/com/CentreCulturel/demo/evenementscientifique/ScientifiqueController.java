package com.CentreCulturel.demo.evenementscientifique;

import java.sql.Date;
import java.time.LocalDate;
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

import com.CentreCulturel.demo.culturel.CulturelResponse;
import com.CentreCulturel.demo.idee.IdeeRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/EventScientifiques")
@RequiredArgsConstructor
public class ScientifiqueController {
	private final ScientifiqueServiceImpl service;
	@PostMapping("/dept/{iddept}")
	public ResponseEntity<Integer> save(@RequestBody @Valid ScientifiqueRequest scientreq,
			@PathVariable(value = "iddept") Integer id ){
	
		return ResponseEntity.accepted()
				             .body(service.save(scientreq,id));
	}
    @GetMapping("/{scient_id}")
    public ResponseEntity<ScientifiqueResponse>findById(@PathVariable("scient_id") Integer id){
    	return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/search/{date}")
    public ResponseEntity<ScientifiqueResponse> findByDate(@PathVariable LocalDate date){
    	return ResponseEntity.ok(service.findByDateCreation(date));
    }
    @GetMapping("/All")
    public ResponseEntity<List<ScientifiqueResponse>> findAll(){
    	return ResponseEntity.ok(service.findAll());
    	
    }
    @DeleteMapping("/{scient_id}")
    public ResponseEntity<Void> deleteById(@PathVariable("scient_id") Integer id){
    	service.deleteById(id);
    	return ResponseEntity.ok().build();
    }
    @GetMapping("/EventScientifiques/{depart_id}")
    public ResponseEntity<List<ScientifiqueResponse>> findEventByDepartement(@PathVariable(value="depart_id") Integer id){
    	return ResponseEntity.ok(service.ListEventSicentifiqueByIdDepartement(id));
    }
    @PostMapping("/EventScientifiques/{event_id}/Utilisateur/{user_id}")
    public ResponseEntity<Void> Assignement(@PathVariable(value="event_id") Integer eventId,@PathVariable(value="user_id") Integer user_Id) {
    	service.assignementUserToEventScientifique(eventId, user_Id);
    	return ResponseEntity.ok().build();
    }
    @GetMapping("/EventScientifique/Utlisateur/{user_id}")
    public ResponseEntity<List<ScientifiqueResponse>> findEventByUtilisateur(@PathVariable(value="user_id") Integer id){
    	return ResponseEntity.ok(service.ListEventByUtilisateur(id));
}
    @PutMapping("/update/departement/{dept_id}")
	public ResponseEntity<Integer> updateEventScientifique(@RequestBody ScientifiqueRequest scientreq, @PathVariable(value="dept_id")  Integer id){
		return ResponseEntity.ok(service.edit(scientreq, id));
	}
}
