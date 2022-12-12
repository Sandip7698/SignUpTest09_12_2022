package com.example.demo.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.SignUpdto;
import com.example.demo.model.SignUp;

public interface SignUpServices {

	ResponseEntity<String> save(SignUpdto signUpdto);

	Optional<SignUp> findByemail(String email);

	Optional<SignUp> findBypassword(String password);

	ResponseEntity<String> login(SignUpdto signUpdto);

}
