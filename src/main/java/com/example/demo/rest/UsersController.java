package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.TicketInfoDto;
import com.example.demo.dto.UserSignUpRequest;
import com.example.demo.service.TicketInfoService;
import com.example.demo.service.UsersInfoService;

@Controller
@RequestMapping
public class UsersController {
	
	@Autowired
	UsersInfoService userServiceInfo;
	
	@Autowired
	TicketInfoService ticketInfoService;
	
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
	
	@PostMapping(value="/createTicket")
	public ResponseEntity<?> createTicket(@RequestBody TicketInfoDto ticketInfoDto){
		try {
		ticketInfoService.addTicketInfo(ticketInfoDto);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			log.error("Exception occurred while creating ticket info {} {}", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@PutMapping(value = "/updateTicket/ticketId/{ticketId}")
	public ResponseEntity<?> updateTicket(@PathVariable String ticketId, @RequestBody TicketInfoDto ticketInfoDto){
		try {
		ticketInfoService.updateTicketInfo(ticketInfoDto, ticketId);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			log.error("Exception occurred while updating ticket info {} {}", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getData(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
