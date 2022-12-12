package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SignUp;

public interface SignUpRepository extends JpaRepository<SignUp,Long> {

	Optional<SignUp> findByemail(String email);
	Optional<SignUp> findBypassword(String password);
	Optional<SignUp> findByEmail(String email);
	

}
