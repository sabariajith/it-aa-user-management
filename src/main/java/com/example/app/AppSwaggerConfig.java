package com.example.app;

import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppSwaggerConfig {
	
	@Bean
	OperationCustomizer customHeaders() {
		return (Operation operation, HandlerMethod handlerMethod) -> {
			return operation;
		};
	}

	@Bean
	OpenAPI myOpenAPI() {

		Info info = new Info()
				.title("User Management API")
				.version("1.0")
				.description("This API exposes endpoints to user management.");

		return new OpenAPI().info(info);
	}

}
