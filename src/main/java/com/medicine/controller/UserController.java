package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.dto.UserDto;
import com.medicine.entity.Medicine;
import com.medicine.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	 private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	@PostMapping(path="/registerUser", consumes= {MediaType.ALL_VALUE})
	public String registerUser(@RequestBody UserDto userDto) 
	{
		String msg = userService.createUser(userDto);
	     System.out.println(msg);
	   return msg;
	   }
	
	@PostMapping(path="/user/login", consumes= {MediaType.ALL_VALUE})
	public ResponseEntity<String> login(@RequestBody UserDto loginCredentials){
		if(userService.validateUser(loginCredentials.getUsername(),loginCredentials.getPassword())) {
			return ResponseEntity.ok("Login successful.");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}
	@GetMapping(path="/medicines", consumes= {MediaType.ALL_VALUE})
	public List<Medicine> getAllMedicines(){
		return userService.getAllMedicines();
	}
	@GetMapping("/getUserByUsername/{username}")
	public long getUserByUserName(@PathVariable String username) {
		return userService.getUser(username);
		}


//@GetMapping("/viewprofile/{userid}")
//public ResponseEntity<?> viewProfileController(@PathVariable Long userid)
//{
//	return userService.viewProfile(userid);
//	}
}

