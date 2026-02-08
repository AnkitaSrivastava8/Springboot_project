package com.example.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.Enums.TicketStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "tickets_info")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketInfo {
	@Id
	String id;
	String ticketTitle;
	String ticketDescription;
	String createdBy;
	String modifiedBy;
	TicketStatus status;

}
