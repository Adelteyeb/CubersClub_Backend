package com.CentreCulturel.demo.auth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.writers.frameoptions.StaticAllowFromStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthentificationController {
	private final AuthentificationService authentificationService;
@PostMapping("/register")
public ResponseEntity<AuthentificationResponse> register(@ModelAttribute RegisterRequest registerRequest, 
		                                              @RequestParam("image") MultipartFile file) throws IOException{
	 final  String uploadDirectory=System.getProperty("user.dir")+"/src/main/resources/images/";
	 String  contentType  = file.getContentType(); 
	 
	 if (!contentType.equals( "image/jpeg" ) && !contentType.equals( "image/png" )) { 
	     throw  new  IllegalArgumentException ( "Seules les images JPEG ou PNG sont autorisées" ); 
	 }
	 String OriginalFileName=file.getOriginalFilename();
	Path FileNameAndPath=Paths.get(uploadDirectory,OriginalFileName);
	Files.write(FileNameAndPath, file.getBytes());
	registerRequest.setUrl(OriginalFileName);
	return ResponseEntity.ok(authentificationService.registrer(registerRequest));
	
}
@PostMapping("/authenticate")
public ResponseEntity<AuthentificationResponse> register(@RequestBody AuthenticateRequest authSRequest){
	return ResponseEntity.ok(authentificationService.authenticate(authSRequest));
}
}
