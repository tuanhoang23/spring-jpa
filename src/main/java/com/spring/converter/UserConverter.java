package com.spring.converter;

import com.spring.entity.RoleEntity;
import org.springframework.stereotype.Component;

import com.spring.DTO.UserDTO;
import com.spring.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

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
		List<RoleEntity> roles = new ArrayList<>();
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setId(dto.getId());
		roles.add(roleEntity);
		UserEntity user = new UserEntity();
		user.setFullName(dto.getFullname());
		user.setUserName(dto.getUsername());
		user.setPassWord(dto.getPassword());
		user.setStatus(dto.getStatus());
		user.setRoles(roles);
		return user;
		
	}
}
