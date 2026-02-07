package com.example.demo.rest;

import org.apache.el.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserSignUpRequest;
import com.example.demo.service.UsersInfoService;

@Controller
@RequestMapping
public class UsersController {
	
	@Autowired
	UsersInfoService userServiceInfo;
	
	public static final Logger log = LoggerFactory.getLogger(UsersController.class);
	
	@PostMapping(value="/signUp")
	public ResponseEntity<?> userSignUp(@RequestBody UserSignUpRequest userSignUpRequest){
		try {
		userServiceInfo.userSignUp(userSignUpRequest);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			log.error("Exception occurred while adding new user details {} {}", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> userLogin(){
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	@GetMapping
	public ResponseEntity<?> getData(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
