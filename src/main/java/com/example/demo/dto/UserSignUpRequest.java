package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class UserSignUpRequest {
	private String id;
     private String firstName;
     private String lastName;
     private String username;
     private String password;
     private String mailId;
}
