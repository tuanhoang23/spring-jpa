package com.spring.DAO;

import java.util.List;

import com.spring.model.newsModel;



public interface iNewDAO extends genericDAO<newsModel> {
	List<newsModel> findAll();

	
}
