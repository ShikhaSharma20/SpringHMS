package com.springhms.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springhms.dto.userDto;
import com.springhms.exception.globalException;
import com.springhms.model.authRequest;
import com.springhms.model.user;
import com.springhms.serviceimpl.userServiceImpl;
import com.springhms.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class userController {
	//Here we control and handle all rest API 
	//Here we perform dependency injection 
	@Autowired
	private userServiceImpl service;
	
	//Here we perform dependency injection
	@Autowired
	AuthenticationManager authManager;
	
	//Here we perform dependency injection
	@Autowired
	JwtUtil jwt;
	
	//Here we deal with rest API of generateToken
	@PostMapping("/authentication")
	public String generateToken(@RequestBody authRequest ar) {
	
		authManager.authenticate(
        new UsernamePasswordAuthenticationToken(ar.getUserName(),ar.getUserPassword()));
		return jwt.generateToken(ar.getUserName());
		
	}
	
	//Here we deal with rest API of getUser
	@GetMapping("/get")
	public ResponseEntity<List<user>> getUsers(){	
		List<user> userList=service.getUser();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	
	//Here we deal with rest API of add user
	@PostMapping("/add")
	public ResponseEntity<user> addUsers(@RequestBody @Valid userDto u1){
		return new ResponseEntity<>(service.addUser(u1),HttpStatus.ACCEPTED);
		
	}

	//Here we deal with rest API of update user
	@PutMapping("/update")
	public ResponseEntity<user> updateUser(@RequestBody @Valid userDto u1){
		return new ResponseEntity<>(service.updateUser(u1),HttpStatus.ACCEPTED);
	}
	
	//Here we deal with rest API of delete user
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable int userid) throws globalException{
		String status=service.deleteUser(userid);
		if(status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Here we deal with rest API of update phone
	@PutMapping("/phone/{id}/{phone}")
	public ResponseEntity<String> updatePhone(@PathVariable int id,@PathVariable String phone) throws globalException{
		return new ResponseEntity<>(service.updatePhone(id, phone),HttpStatus.OK);
		
	}
	
	//Here we deal with rest API of allot room
	@PutMapping("/allotroom/{userid}/{roomid}")
	public ResponseEntity<String> allotRoom(@PathVariable int userid,@PathVariable int roomid) throws globalException{
		return new ResponseEntity<>(service.allotRoom(userid, roomid),HttpStatus.OK);
		
	}
	
	//Here we deal with rest API of update fee 
	@PutMapping("/updatefee/{userid}/{userfee}")
	public ResponseEntity<String> update(@PathVariable int userid,@PathVariable int userfee) throws globalException{
		return new ResponseEntity<>(service.updateFee(userid, userfee),HttpStatus.OK);
		
	}
	

}