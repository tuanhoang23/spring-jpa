package com.spring.DTO;

public class UserDTO extends AbstractDTO<UserDTO>{
	private String fullname;
	private String password;
	private int status;
	private String username;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String fullname, String password, int status, String username) {
		super();
		this.fullname = fullname;
		this.password = password;
		this.status = status;
		this.username = username;
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
