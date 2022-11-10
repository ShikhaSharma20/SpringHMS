package com.springhms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class user {
	
	// Here we are  creating user model
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)     
	private int userId;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userEmail;
	private String userRole;
	private int userFee;
	
	// Here we perform many to one relation between room and user
	@ManyToOne
	private room userRoom;
	
	
}