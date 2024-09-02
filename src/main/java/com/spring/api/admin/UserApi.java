package com.spring.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.DTO.UserDTO;

@RestController(value ="UserApiOfAdmin")
public class UserApi {
	
	@PostMapping("/api/user")
	public UserDTO addUser(@RequestBody UserDTO userDto) {
		return userDto;
	}
	
	@PutMapping("/api/user")
	public UserDTO updateUser(@RequestBody UserDTO userDto) {
		return userDto;
	}
	
	@DeleteMapping("/api/user")
	public void remove(@RequestBody Long[] ids) {
		
	}
}
