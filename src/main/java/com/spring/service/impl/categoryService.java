package com.spring.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.CategoryEntity;
import com.spring.repository.categoryRepository;
import com.spring.service.iCategoryService;

@Service
public class categoryService implements iCategoryService {
	@Autowired
	private categoryRepository categoryRepository;
	

	@Override
	public Map<String,String> findAll() {
		Map<String,String> models = new HashMap<>();
		List<CategoryEntity> entity = categoryRepository.findAll() ;
		for(CategoryEntity item:entity) {
			models.put(item.getCode(), item.getName());
		}
		return models;
	}

}
