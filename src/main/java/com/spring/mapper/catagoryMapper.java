package com.spring.mapper;

import java.sql.ResultSet;

import com.spring.model.catagoriesModel;



public class catagoryMapper implements rowMapper<catagoriesModel> {

	@Override
	public catagoriesModel mapRow(ResultSet resultSet) {
		catagoriesModel catagory = new catagoriesModel();
		try {
			catagory.setId(resultSet.getLong("id"));
			catagory.setCode(resultSet.getString("code"));
			catagory.setName(resultSet.getString("name"));
			catagory.setCreateAt(resultSet.getTimestamp("create_at"));
			catagory.setCreateBy(resultSet.getString("createby"));
			if(resultSet.getTimestamp("modifile_at") != null) {
				catagory.setModifileAt(resultSet.getTimestamp("modifile_at"));
				catagory.setModifileBy(resultSet.getString("modifileby"));
			}
			return catagory;
		} catch (Exception e) {
			return null;
		}
	}
	
}
