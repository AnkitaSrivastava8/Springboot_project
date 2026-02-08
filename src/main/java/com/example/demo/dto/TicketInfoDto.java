package com.example.demo.dto;

import com.example.demo.Enums.TicketStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketInfoDto {
	
	String ticketTitle;
	String ticketDescription;
	String createdBy;
	String modifiedBy;
	TicketStatus status;
}
