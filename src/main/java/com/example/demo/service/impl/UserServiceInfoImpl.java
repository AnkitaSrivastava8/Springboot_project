package com.example.demo.service.impl;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserInfo;
import com.example.demo.dto.UserSignUpRequest;
import com.example.demo.service.UsersInfoService;

@Service
public class UserServiceInfoImpl implements UsersInfoService{
	
	private final MongoTemplate mongoTemplate;
	
	public UserServiceInfoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void userSignUp(UserSignUpRequest userSignUpRequest) {
		UserInfo user = convertDtoToEntity(userSignUpRequest);
		
		mongoTemplate.save(user, "users");
	}
	
	public UserInfo convertDtoToEntity(UserSignUpRequest userSignUpRequest) {
		UserInfo user = new UserInfo(userSignUpRequest.getFirstName(), userSignUpRequest.getLastName(), userSignUpRequest.getUsername(), userSignUpRequest.getMailId(), userSignUpRequest.getPassword());
		return user;
	}

}
