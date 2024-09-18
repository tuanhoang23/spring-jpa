package com.spring.api.admin;

import com.spring.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.DTO.UserDTO;

@RestController(value ="UserApiOfAdmin")
public class UserApi {

	@Autowired
	private iUserService userService;


	@PostMapping("/api/user")
	public UserDTO addUser(@RequestBody UserDTO userDto) {
		return userService.save(userDto);
	}
	
	@PutMapping("/api/user")
	public UserDTO updateUser(@RequestBody UserDTO userDto) {
		return userDto;
	}
	
	@DeleteMapping("/api/user")
	public void remove(@RequestBody Long[] ids) {
		
	}
}
