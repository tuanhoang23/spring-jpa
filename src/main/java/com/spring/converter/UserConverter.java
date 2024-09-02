package com.spring.converter;

import org.springframework.stereotype.Component;

import com.spring.DTO.UserDTO;
import com.spring.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDto (UserEntity entity) {
		UserDTO user = new UserDTO();
		user.setId(entity.getId());
		user.setFullname(entity.getFullName());
		user.setUsername(entity.getUserName());
		user.setPassword(entity.getPassWord());
		user.setStatus(entity.getStatus());
		return user;
		
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity user = new UserEntity();
		user.setFullName(dto.getFullname());
		user.setUserName(dto.getUsername());
		user.setPassWord(dto.getPassword());
		user.setStatus(dto.getStatus());
		return user;
		
	}
}
