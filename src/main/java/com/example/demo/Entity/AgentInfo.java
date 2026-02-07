package com.example.demo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "agent_info")

@AllArgsConstructor
@NoArgsConstructor
public class AgentInfo {
	
	String agentName;
	String phoneNumber;
	String mailId;
	

}
