package com.example.demo.service.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.Entity.UserInfo;
import com.example.demo.dto.UserLoginRequest;
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
		UserInfo user = new UserInfo(userSignUpRequest.getId(), userSignUpRequest.getFirstName(), userSignUpRequest.getLastName(), userSignUpRequest.getUsername(), userSignUpRequest.getMailId(), userSignUpRequest.getPassword());
		return user;
	}

	@Override
	public boolean userLogin(UserLoginRequest userLoginRequest) {
		String username = userLoginRequest.getUserName();
		Query findQuery = new Query();
	    findQuery.addCriteria(Criteria.where("userName").is(username));
	    List<UserInfo> user = mongoTemplate.find(findQuery, UserInfo.class);
	    if(user != null && !CollectionUtils.isEmpty(user)) {
	    	UserInfo u1 = user.get(0);
	    	if(u1.getPassword().equals(userLoginRequest.getPassword()))
	    		return true;
	    	return false;
	    }
		return false;
	}

}
