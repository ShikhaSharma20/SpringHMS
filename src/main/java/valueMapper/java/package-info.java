package com.springhms.util;

import com.springhms.dto.roomDto;
import com.springhms.dto.userDto;
import com.springhms.model.room;
import com.springhms.model.user;

public class valueMapper {
	
	// Here we convert userDTo object into user object
	public static user convertoUser(userDto u1) {
		user u2=new user(u1.getUserId(), u1.getUserName(),u1.getUserPassword(),u1.getUserPhone(),u1.getUserEmail(),u1.getUserRole(),u1.getUserFee(),u1.getUserRoom());
		return u2;	
	}
	
	public static room convertoRoom(roomDto r1) {
		room r2=new room(r1.getRoomId(),r1.getRoomName(),r1.getRoomType());
		return r2;
	}
	

}