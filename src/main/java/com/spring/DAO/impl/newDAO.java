package com.spring.DAO.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.DAO.iNewDAO;
import com.spring.mapper.newMapper;
import com.spring.model.newsModel;


@Repository
public class newDAO extends abstractDAO<newsModel> implements iNewDAO {
	@Override
	public List<newsModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		return query(sql.toString(),new newMapper());
	}


}
