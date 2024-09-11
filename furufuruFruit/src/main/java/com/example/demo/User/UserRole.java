package com.example.demo.User;

import lombok.Getter;

@Getter
public enum UserRole {
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER"),
	SALEUSER("ROLE_SALEUSER");
	
	private String value;
	
	UserRole(String value) {
		this.value = value;
	}
}
	