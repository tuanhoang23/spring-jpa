package com.spring.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.RoleEntity;
import com.spring.repository.roleRepository;
import com.spring.service.iRoleService;

@Service
public class roleService implements iRoleService {

	@Autowired
	private roleRepository roleRepository;

	@Override
	public Map<String, String> findAll() {
		Map<String,String> role = new HashMap<>();
		List<RoleEntity> entity = roleRepository.findAll();
		for(RoleEntity item: entity) {
			role.put(item.getCode(), item.getName());
		}
		return role;
	}
	


}
