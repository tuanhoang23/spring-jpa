package com.spring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.spring.DTO.UserDTO;
import com.spring.entity.RoleEntity;

public interface iUserService {
	List<UserDTO> findByUserNameAndStatus();
	List<UserDTO> findAll(Pageable pageable);
	int totalItems();
	UserDTO findById(Long id);

}
