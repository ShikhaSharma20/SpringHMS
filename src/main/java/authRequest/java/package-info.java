package com.springhms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class authRequest {
	
	// Here we perform authentication for user 
	private String userName;
	private String userPassword;

}