package com.springhms.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class roomDto {
	
	// Here we perform validation for room model 
	@NotNull(message="room id cannot be null")
	private int roomId;
	
	@NotNull(message="room name cannot be null")
	private String roomName;
	
	@NotNull(message="room type cannot be null")
	private String roomType;

}