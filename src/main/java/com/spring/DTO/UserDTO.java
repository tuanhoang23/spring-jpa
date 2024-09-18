package com.spring.DTO;

import java.util.List;

public class UserDTO extends AbstractDTO<UserDTO>{
	private String fullname;
	private String password;
	private int status;
	private String username;

	private List<Long> roleIds;

	private String code_role;

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public UserDTO() {
		
	}
	
	public UserDTO(String fullname, String password, int status, String username) {
		super();
		this.fullname = fullname;
		this.password = password;
		this.status = status;
		this.username = username;
	}

	public String getCode_role() {
		return code_role;
	}

	public void setCode_role(String code_role) {
		this.code_role = code_role;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
