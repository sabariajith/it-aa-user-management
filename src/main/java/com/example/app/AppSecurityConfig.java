package com.example.app;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AppSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		//var jwtIssuerAuthenticationManagerResolver = getJwtIssuerAuthenticationManagerResolver();
		
		return http.cors(customize -> customize.configurationSource(corsConfigurationSource()))
				.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
				.authorizeHttpRequests((authorize) -> authorize
						// Allow access to Swagger
						.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
						.requestMatchers(GET).permitAll()
						.requestMatchers(POST).permitAll()
						// Authenticate all other requests
						.anyRequest().authenticated())
				//.oauth2ResourceServer(oauth -> oauth.authenticationManagerResolver(jwtIssuerAuthenticationManagerResolver))
				.build();

	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		return request -> {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowedOrigins(Arrays.asList(getClientHost(request)));
			config.setAllowCredentials(true);
			config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
			config.setAllowedHeaders(Arrays.asList("Access-control-Allow-Credentials", "Access-Control-Allow-Headers", 
					"Origin", "Accept", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers",
					"authorization", "Access-Control-Expose-Headers"));
			config.setMaxAge(3600L);
			return config;
		};
	}
	
	private String getClientHost(HttpServletRequest request ) {
		String client = request.getHeader("origin");
		return client;
	}

	public void configure(WebSecurity web) {
		web.ignoring().requestMatchers("/v3/api-docs/**", "/swagger-ui/**");
	}

}
