package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SignUpdto;
import com.example.demo.model.SignUp;
import com.example.demo.service.SignUpServices;

@RestController
public class SignUpContoller {

	@Autowired
	SignUpServices signUpServices;
	
	@PostMapping("/save")
	public ResponseEntity<String> savedata(@RequestBody SignUpdto signUpdto){
		return signUpServices.save(signUpdto);
	}
	
	@GetMapping("/email/{email}")
	public Optional<SignUp> getemails(@PathVariable String email){
		return signUpServices.findByemail(email);
	}
	
	@GetMapping("/pass/{password}")
	public Optional<SignUp> getpass(@PathVariable String password){
		return signUpServices.findBypassword(password);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody SignUpdto signUpdto){
		return signUpServices.login(signUpdto);
	}
}
