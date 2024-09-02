package com.spring.converter;

import org.springframework.stereotype.Component;

import com.spring.DTO.categoryDTO;
import com.spring.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public categoryDTO toDto (CategoryEntity entity) {
		categoryDTO result = new categoryDTO();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		return result;
	}
	
	public CategoryEntity toEntity (categoryDTO dto) {
		CategoryEntity result = new CategoryEntity();
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		return result;
	}
}
