package com.example.demo.service.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.CollectionUtils;

import com.example.demo.Entity.AgentInfo;
import com.example.demo.dto.AgentInfoDto;
import com.example.demo.service.AgentInfoService;

public class AgentServiceImpl implements AgentInfoService{

	private final MongoTemplate mongoTemplate;
	
	public AgentServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public void createAgent(AgentInfoDto agentInfoDto) {
		AgentInfo agentInfo = convertDtoToEntity(agentInfoDto);
		mongoTemplate.save(agentInfo, "agent_info");
		
	}

	@Override
	public boolean agentLogin(AgentInfoDto agentInfoDto) {
		String agentName = agentInfoDto.getAgentName();
		Query query = new Query();
		query.addCriteria(Criteria.where("agentName").is(agentName));
		List<AgentInfo> agentlist = mongoTemplate.find(query, AgentInfo.class);
		if(!CollectionUtils.isEmpty(agentlist)) {
			AgentInfo agentInfo = agentlist.get(0);
			if(agentInfo.getPassword().equals(agentInfoDto.getPassword()))
				return true;
		}
		return false;
	}
	
	public AgentInfo convertDtoToEntity(AgentInfoDto agentInfoDto) {
		AgentInfo agentInfo = new AgentInfo(agentInfoDto.getId(),agentInfoDto.getAgentName(),agentInfoDto.getPassword(), agentInfoDto.getPhoneNumber(),agentInfoDto.getMailId());
		return agentInfo;
	}

}
