package com.springhms.service;

import java.util.List;
import com.springhms.dto.roomDto;
import com.springhms.exception.globalException;
import com.springhms.model.room;

public interface roomService {
    // Here we declared all method which is use in roomServiceImpl class 
	public room addRoom(roomDto r1);
	public List<room> getRoom();
	public room updateRoom(roomDto r1);
	public String deleteRoom(int roomid) throws globalException;
	
}