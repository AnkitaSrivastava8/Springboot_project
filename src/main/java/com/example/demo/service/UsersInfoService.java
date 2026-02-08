package com.example.demo.service;

import com.example.demo.dto.UserLoginRequest;
import com.example.demo.dto.UserSignUpRequest;

public interface UsersInfoService {

	
	public void userSignUp(UserSignUpRequest userSignUpRequest);
	
	public boolean userLogin(UserLoginRequest userLoginRequest);
}
