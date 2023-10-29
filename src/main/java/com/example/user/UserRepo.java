package com.example.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByUserNameOrEmail(String userName, String email);
	
	User findByUserNameAndPassword(String userName, String password);

}