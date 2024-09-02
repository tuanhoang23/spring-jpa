package com.spring.DTO;

public class categoryDTO extends AbstractDTO<categoryDTO> {
	private String name;
	private String code;
	
	public categoryDTO() {
		super();
	}

	
	public categoryDTO(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
