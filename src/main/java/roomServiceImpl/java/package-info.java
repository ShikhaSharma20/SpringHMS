package com.springhms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springhms.dto.roomDto;
import com.springhms.exception.globalException;
import com.springhms.model.room;
import com.springhms.repository.roomRepository;
import com.springhms.service.roomService;
import com.springhms.util.valueMapper;

@Service
public class roomServiceImpl implements roomService {
	
	// Here we implements all methods which is present in roomService interface
	// Here we performed dependency injection
	@Autowired
	private roomRepository roomrepo;
	
	// This is method for add room 
	@Override
	public room addRoom(roomDto r1) {
		room r2=valueMapper.convertoRoom(r1);
		return roomrepo.save(r2);
	}

	// This is method for get room
	@Override
	public List<room> getRoom() {
		return roomrepo.findAll();
	}
	
	// This is method for update room 
	@Override
	public room updateRoom(roomDto r1) {
		room r2=valueMapper.convertoRoom(r1);
		return roomrepo.save(r2);	
	}
	
	// This is method for delete room 
	@Override
	public String deleteRoom(int roomid) throws globalException {
		room r2=roomrepo.findByRoomId(roomid);
		if(r2!=null) {
			roomrepo.deleteById(roomid);
			return "deleted";
		}
		else {
			throw new globalException("Room Notfound");
		}
	}

}