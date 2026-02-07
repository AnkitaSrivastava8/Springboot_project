package com.example.demo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.Enums.TicketStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "tickets_info")

@AllArgsConstructor
@NoArgsConstructor
public class TicketInfo {
	
	String ticketTitle;
	String ticketDescription;
	String createdBy;
	String modifiedBy;
	TicketStatus status;

}
