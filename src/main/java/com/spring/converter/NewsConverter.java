package com.spring.converter;

import org.springframework.stereotype.Component;

import com.spring.DTO.NewDTO;
import com.spring.entity.NewsEntity;

@Component
public class NewsConverter {

	public NewDTO toDto(NewsEntity entity) {
		NewDTO result = new NewDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setThumbnail(entity.getThumbnail());
		result.setContent(entity.getContent());
		result.setShortDescription(entity.getSortDecription());
		result.setCatagoryCode(entity.getCategory().getCode());
		result.setCatagory_Id(entity.getCategory().getId());
		return result;
	}
	
	public NewsEntity toEntity(NewDTO dto) {
		NewsEntity result = new NewsEntity();
		result.setTitle(dto.getTitle());
		result.setThumbnail(dto.getThumbnail());
		result.setContent(dto.getContent());
		result.setSortDecription(dto.getShortDescription());
		return result;
	}
	
	public NewsEntity toEntity(NewsEntity result ,NewDTO dto) {
		result.setTitle(dto.getTitle());
		result.setThumbnail(dto.getThumbnail());
		result.setContent(dto.getContent());
		result.setSortDecription(dto.getShortDescription());
		return result;
	}
}
