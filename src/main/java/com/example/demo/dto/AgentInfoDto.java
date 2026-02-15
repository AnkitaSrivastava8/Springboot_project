package com.example.demo.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgentInfoDto {
	
	@Id
	String id;
	String agentName;
	String password;
	String mailId;
	String phoneNumber;

}
