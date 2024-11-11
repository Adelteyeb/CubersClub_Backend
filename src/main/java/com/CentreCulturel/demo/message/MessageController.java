package com.CentreCulturel.demo.message;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.membre.MembreServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Messages")
public class MessageController {
	private final MessageServiceImpl service;
	@PostMapping("/{id_user}")
	public ResponseEntity<Integer> save( @RequestBody
			@Valid MessageRequest msgreq, @PathVariable(value="id_user") Integer user_id){
		      //utlisreq.setRole("UTIL");
		
		
				return ResponseEntity
						.accepted()
						.body(this.service.saveMessage(msgreq,user_id));
		
	}
	@GetMapping(value="/ALL")
    public ResponseEntity<List<MessageResponse>> findAll(){
    	return ResponseEntity.ok(service.findAll());
    	
    }
	 @DeleteMapping("/{message-id}")
	    public ResponseEntity<Void> delete(@PathVariable("message-id") Integer id){
	    	service.deleteMessage(id);
			return ResponseEntity.ok().build();
	    	
	    }
}
