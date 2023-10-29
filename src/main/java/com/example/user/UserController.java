package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.user.request.LoginRequest;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/v1")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/username")
	public String validateUsername(@RequestParam String userName) {
		return service.validateUsername(userName);
	}

	@PostMapping("/validate")
	public String validatePassword(@Valid @RequestBody LoginRequest request) {
		return service.validatePassword(request);
	}

	@GetMapping("/session")
	public String createUserSession() {
		return service.createUserSession();
	}

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		return service.registerUser(user);
	}

}
