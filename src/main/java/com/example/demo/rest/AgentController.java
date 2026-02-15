package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AgentInfoDto;
import com.example.demo.service.AgentInfoService;

@RequestMapping
public class AgentController {
	
	@Autowired
	AgentInfoService agentService;
	
	public static final Logger log = LoggerFactory.getLogger(AgentController.class);
	
	@PostMapping(value="/agent/createAgent")
	public ResponseEntity<?> createAgent(@RequestBody AgentInfoDto agentInfoDto){
		try {
		agentService.createAgent(agentInfoDto);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			log.error("Exception occurred while creating agent {} {}", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/agent/login")
	public ResponseEntity<?> agentLogin(@RequestBody AgentInfoDto agentInfoDto){
		try {
		agentService.agentLogin(agentInfoDto);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			log.error("Exception occurred while logging in as agent {} {}", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
