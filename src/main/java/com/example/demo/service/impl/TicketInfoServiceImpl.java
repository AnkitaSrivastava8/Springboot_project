package com.example.demo.service.impl;

import org.springframework.data.mongodb.core.MongoTemplate;
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
		TicketInfo ticket = new TicketInfo(ticketInfoDto.getTicketTitle(), ticketInfoDto.getTicketDescription(), ticketInfoDto.getCreatedBy(), ticketInfoDto.getModifiedBy(), ticketInfoDto.getStatus());
		return ticket;
	}

}
