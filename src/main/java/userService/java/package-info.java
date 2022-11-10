package com.springhms.service;

import java.util.List;
import com.springhms.dto.userDto;
import com.springhms.exception.globalException;
import com.springhms.model.user;

public interface userService {
	
	// Here we declared all method which is use in userServiceImpl class 
	public user addUser(userDto u1);
	public List<user> getUser();
	public user updateUser(userDto u1);
	public String deleteUser(int userid) throws globalException;
	public String updatePhone(int userid,String phone)throws globalException;
	public String allotRoom(int userid,int roomid)throws globalException;
	public String updateFee(int userid,int userfee)throws globalException;
}