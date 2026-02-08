package com.example.demo.service;

import com.example.demo.dto.TicketInfoDto;

public interface TicketInfoService {

	public void addTicketInfo(TicketInfoDto ticketInfoDto);
	public void updateTicketInfo(TicketInfoDto ticketInfoDto, String ticketId);
}
