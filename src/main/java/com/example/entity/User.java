package com.example.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@NotNull(message = "First Name should not be null or empty")
	@Column(name="firstname")
    private String firstName;
	@NotNull(message = "Last Name should not be null or empty")
	@Column(name="lastname")
    private String lastName;
    @Column(name="username", nullable = false, unique = true)
    @NotNull(message = "User Name should not be null or empty")
    private String userName;
    @Column(nullable = false, unique = true)
    @NotNull(message = "Email should not be null or empty")
    private String email;
    @Column(nullable = false)
    private String password;

}
