package com.CentreCulturel.demo.culturel;

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

import com.CentreCulturel.demo.evenementscientifique.ScientifiqueRequest;
import com.CentreCulturel.demo.evenementscientifique.ScientifiqueResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/EventCulturels")
@RequiredArgsConstructor
public class CulturelController {
	private final CulturelServiceImpl service;
	@PostMapping("/dept/{id}")
	public ResponseEntity<Integer> save(@RequestBody @Valid CulturelRequest cultreq, @PathVariable(value="") Integer id){
		return ResponseEntity.accepted()
				             .body(service.save(cultreq,id));
	}
    @GetMapping("/{cult_id}")
    public ResponseEntity<CulturelResponse>findById(@PathVariable("cult_id") Integer id){
    	return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/search/{date}")
    public ResponseEntity<CulturelResponse> findByDate(@PathVariable LocalDate date){
    	return ResponseEntity.ok(service.findByDateCreation(date));
    }
    @GetMapping("/All")
    public ResponseEntity<List<CulturelResponse>> findAll(){
    	return ResponseEntity.ok(service.findAll());
    	
    }
    @DeleteMapping("/{cult_id}")
    public ResponseEntity<Void> deleteById(@PathVariable("cult_id") Integer id){
    	service.deleteById(id);
    	return ResponseEntity.ok().build();
    }
    @GetMapping("/EventCulturels/{depart_id}")
    public ResponseEntity<List<CulturelResponse>> findEventByDepartement(@PathVariable(value="depart_id") Integer id){
    	return ResponseEntity.ok(service.findEventCulturelByDepartementId(id));
}
    @PostMapping("/EventCulturel/{event_id}/Utilisateur/{user_id}")
    public ResponseEntity<Void> Assignement(@PathVariable(value="event_id") Integer eventId,@PathVariable(value="user_id") Integer user_Id) {
    	service.assignementUserToEventCulturel(eventId, user_Id);
    	return ResponseEntity.ok().build();
    }
    @GetMapping("/EventCulturels/Utlisateur/{user_id}")
    public ResponseEntity<List<CulturelResponse>> findEventByUtilisateur(@PathVariable(value="user_id") Integer id){
    	return ResponseEntity.ok(service.ListEventByUtilisateur(id));
}
    @PutMapping("/update/departement/{dept_id}")
   	public ResponseEntity<Integer> updateEventCulturel(@RequestBody CulturelRequest cultreq, @PathVariable(value="dept_id")  Integer id){
   		return ResponseEntity.ok(service.edit(cultreq, id));
   	}
}
