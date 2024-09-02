package com.spring.model;

public class catagoriesModel extends abstractModel<catagoriesModel> {
	
	private String name;
	private String code;
	
	public catagoriesModel() {
		super();
	}

	
	public catagoriesModel(String name, String code) {
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
