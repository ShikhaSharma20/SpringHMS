package roomController.java;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springhms.dto.roomDto;
import com.springhms.exception.globalException;
import com.springhms.model.room;
import com.springhms.serviceimpl.roomServiceImpl;

@RestController
@RequestMapping("/room")
public class roomController {
	
	//Here we control and handle all the rest API 
    //Here we performing  dependency injection 
	@Autowired
	private roomServiceImpl service;
	
	//Here we deal with rest API of get room
	@GetMapping("/get")
	public ResponseEntity<List<room>> getRooms(){
		return new ResponseEntity<>(service.getRoom(),HttpStatus.OK);	
	}
	
	//Here we deal with rest API of add room
	@PostMapping("/add")
	public ResponseEntity<room> addRoom(@RequestBody @Valid roomDto r1){
		return new ResponseEntity<>(service.addRoom(r1),HttpStatus.ACCEPTED);
		
	}
	//Here we deal with rest API of update room 
	@PutMapping("/update")
	public ResponseEntity<room> updateRoom(@RequestBody @Valid roomDto r1){
		return new ResponseEntity<>(service.updateRoom(r1),HttpStatus.ACCEPTED);
		
	}
	
	//Here we deal with rest API of delete room 
	@DeleteMapping("/delete/{roomid}")
	public ResponseEntity<String> deleteRoom(@PathVariable int roomid) throws globalException{
		String st=service.deleteRoom(roomid);
		if(st!=null) {
			return new ResponseEntity<>(st,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(st,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}