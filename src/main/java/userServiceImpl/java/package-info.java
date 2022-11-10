package com.springhms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springhms.dto.userDto;
import com.springhms.exception.globalException;
import com.springhms.model.user;
import com.springhms.repository.userRepository;
import com.springhms.service.userService;
import com.springhms.util.valueMapper;

@Service
public class userServiceImpl implements userService {

	// Here we implements all methods which is present in userService interface
	// Here we performed dependency injection 
    @Autowired
	private userRepository userrepo;  
	
    // This is method for add user 
	@Override
	public user addUser(userDto u1) {
		user u2=valueMapper.convertoUser(u1);
		return userrepo.save(u2);
	}

	// This is method for get user 
	@Override
	public List<user> getUser() {
		return userrepo.findAll();
		
	}

	// This is method for update user 
	@Override
	public user updateUser(userDto u1) {
		user u2=valueMapper.convertoUser(u1);
		return userrepo.save(u2);
		
	}

	// This is method for delete user 
	@Override
	public String deleteUser(int userid) throws globalException {
		user u2=userrepo.findByUserId(userid);
		if(u2!=null) {
			userrepo.deleteById(userid);
			return "deleted";
		}
		else {
			throw new globalException("user not found");
		}
	}

	// This is method for update phone number of user 
	@Override
	public String updatePhone(int userid, String phone) throws globalException {
		int st=userrepo.updatePhone(userid, phone);
		if(st==1) {
			return "updated!...";
		}
		else {
			throw new globalException("something went wrong");
		}
	}

	// This is method for all room to the user
	@Override
	public String allotRoom(int userid, int roomid) throws globalException {
		int st=userrepo.allotRoom(userid, roomid);
		if(st==1) {
			return "Room Alloted to "+userid;
		}
		else {
			throw new globalException("something went wrong");
		}
	}

	// This is method for update user's fee  
	@Override
	public String updateFee(int userid, int userfee) throws globalException {
		int st=userrepo.updateFee(userid, userfee);
		if(st==1) {
			return "Fee Updated to "+userid;
		}
		else {
			throw new globalException("something went wrong");
		}
	}

}