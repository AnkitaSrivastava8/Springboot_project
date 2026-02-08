package com.example.demo.service.impl;

import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.TicketInfo;
import com.example.demo.dto.TicketInfoDto;
import com.example.demo.service.TicketInfoService;

@Service
public class TicketInfoServiceImpl implements TicketInfoService{

	private final MongoTemplate mongoTemplate;
	
	public TicketInfoServiceImpl(MongoTemplate mongoTemplate){
		this.mongoTemplate = mongoTemplate;
	}
	@Override
	public void addTicketInfo(TicketInfoDto ticketInfoDto) {
		TicketInfo ticket = convertDtoToEntity(ticketInfoDto);
		
		mongoTemplate.save(ticket, "tickets_info");
	}
	
	public TicketInfo convertDtoToEntity(TicketInfoDto ticketInfoDto) {
		TicketInfo ticket = new TicketInfo(ticketInfoDto.getId(), ticketInfoDto.getTicketTitle(), ticketInfoDto.getTicketDescription(), ticketInfoDto.getCreatedBy(), ticketInfoDto.getModifiedBy(), ticketInfoDto.getStatus());
		return ticket;
	}
	@Override
	public void updateTicketInfo(TicketInfoDto ticketInfoDto, String ticketId) {
		TicketInfo ticket = mongoTemplate.findById(ticketId, TicketInfo.class);
		ticket.setStatus(ticketInfoDto.getStatus());
		mongoTemplate.save(ticket, "tickets_info");
	}
	@Override
	public List<TicketInfo> getTicketList(String userId) {
		Query findQuery = new Query();
		findQuery.addCriteria(Criteria.where("createdBy").is(userId));
		List<TicketInfo> ticketList = mongoTemplate.find(findQuery, TicketInfo.class);
		return ticketList;
	}

}
