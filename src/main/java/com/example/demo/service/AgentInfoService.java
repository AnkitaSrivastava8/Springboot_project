package com.example.demo.service;

import com.example.demo.dto.AgentInfoDto;

public interface AgentInfoService {

	public void createAgent(AgentInfoDto agentInfoDto);
	public boolean agentLogin(AgentInfoDto agentInfoDto);
}
