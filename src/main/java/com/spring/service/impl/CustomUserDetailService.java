package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.DTO.MyUser;
import com.spring.constant.SystemConstant;
import com.spring.entity.RoleEntity;
import com.spring.entity.UserEntity;
import com.spring.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userPepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userPepository.findByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		List <GrantedAuthority> authorities = new ArrayList<>();
		for(RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser user = new MyUser(userEntity.getUserName(), userEntity.getPassWord(), true, true, true, true, authorities);
		user.setFullname(userEntity.getFullName());
		return user;
	}

}
