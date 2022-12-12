package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SignUpRepository;
import com.example.demo.dto.SignUpdto;
import com.example.demo.model.SignUp;
import com.example.demo.service.SignUpServices;

@Service
public class SignUpServiceImpl implements SignUpServices{
@Autowired
SignUpRepository signUpRepository;

@Autowired
BCryptPasswordEncoder bCryptPasswordEncoder;

@Override
public ResponseEntity<String> save(SignUpdto signUpdto) {
	SignUp signup=new SignUp();
	signup.setFullName(signUpdto.getFullName());
	signup.setEmail(signUpdto.getEmail());
	//signup.setPassword(signUpdto.getPassword());
signup.setPassword(bCryptPasswordEncoder.encode(signUpdto.getPassword()));
	signup.setMobileNo(signUpdto.getMobileNo());
	signUpRepository.save(signup);
	
	return new ResponseEntity<>("200 SignUp SucessFully...",HttpStatus.OK);
}

@Override
public Optional<SignUp> findByemail(String email) {

	return signUpRepository.findByEmail(email);
}

@Override
public Optional<SignUp> findBypassword(String password) {
	return signUpRepository.findBypassword(password);
}


@Override
public ResponseEntity<String> login(SignUpdto signUpdto) {
	Optional<SignUp> email=signUpRepository.findByemail(signUpdto.getEmail());
	Optional<SignUp> pass=signUpRepository.findBypassword(signUpdto.getPassword());
	if(email.isPresent() && pass.isPresent()) {
		return new ResponseEntity<>("200 Login SucessFully",HttpStatus.OK);
	}
	return new ResponseEntity<>("Invalid Criditional",HttpStatus.OK);
}



}
