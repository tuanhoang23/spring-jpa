package com.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.spring.model.newsModel;



public class newMapper implements rowMapper<newsModel> {

	public newsModel mapRow(ResultSet resultSet) {
		
		
		try {
			newsModel news = new newsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setThumbnail(resultSet.getNString("thumbnail"));
			news.setShortDescription(resultSet.getNString("shortdescription"));
			news.setContent(resultSet.getNString("content"));
			news.setCatagory_Id(resultSet.getLong("catagory_id"));
			news.setCreateAt(resultSet.getTimestamp("create_at"));
			news.setCreateBy(resultSet.getString("createby"));
			if(resultSet.getTimestamp("modifile_at") != null) {
				news.setModifileAt(resultSet.getTimestamp("modifile_at"));
			}
			if(resultSet.getString("modifileby") != null) {
				news.setModifileBy(resultSet.getString("modifileby"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}
	}

}
