package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.DTO.UserDTO;
import com.spring.converter.UserConverter;
import com.spring.entity.UserEntity;
import com.spring.repository.UserRepository;
import com.spring.service.iUserService;

@Service
public class userService implements iUserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	
	@Override
	public List<UserDTO> findByUserNameAndStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> userdto = new ArrayList<>();
		List<UserEntity> user = userRepository.findAll(pageable).getContent();
		for(UserEntity item : user) {
			UserDTO dtouser = userConverter.toDto(item);
			userdto.add(dtouser);
		}
		return userdto;
	}

	@Override
	public int totalItems() {
		return (int)userRepository.count();
	}

	@Override
	public UserDTO findById(Long id) {
		UserEntity user = userRepository.findOne(id);
		return userConverter.toDto(user);
	}

}
