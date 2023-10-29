package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.user.request.LoginRequest;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;

	public String validateUsername(String userName) {
		User user = repo.findByUserNameOrEmail(userName, userName);
		if (user != null) {
			return "success";
		} else {
			return "User Name not found.";
		}
	}
	
	public String validatePassword(LoginRequest request) {
		User user = repo.findByUserNameAndPassword(request.getUserName(), request.getPassword());
		if (user != null) {
			return "success";
		} else {
			return "Incorrect username or password.";
		}
	}
	
	public String createUserSession() {
		return "";
	}
	
	public String registerUser(User user) {
		repo.save(user);
		return "success";
	}

}
