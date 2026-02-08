package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.TicketInfo;
import com.example.demo.dto.TicketInfoDto;

public interface TicketInfoService {

	public void addTicketInfo(TicketInfoDto ticketInfoDto);
	public void updateTicketInfo(TicketInfoDto ticketInfoDto, String ticketId);
	public List<TicketInfo> getTicketList(String userId);
}
