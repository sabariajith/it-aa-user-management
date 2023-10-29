package com.example.user.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
	
	@NotNull(message = "User Name should not be null or empty")
	private String userName;
	@NotNull(message = "Password should not be null or empty")
	private String password;

}
