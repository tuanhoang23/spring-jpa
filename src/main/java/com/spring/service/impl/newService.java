package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.DTO.NewDTO;
import com.spring.converter.CategoryConverter;
import com.spring.converter.NewsConverter;
import com.spring.entity.CategoryEntity;
import com.spring.entity.NewsEntity;
import com.spring.repository.categoryRepository;
import com.spring.repository.iNewRepository;
import com.spring.service.iNewsService;


@Service
public class newService implements iNewsService {
	@Autowired
	private NewsConverter newConverter;
	
	@Autowired
	private categoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private iNewRepository newRepository;

	@Override
	public List<NewDTO> findAll(Pageable pageable){
		List<NewDTO> models = new ArrayList<>();
		List<NewsEntity> news = newRepository.findAll(pageable).getContent();
		for(NewsEntity item : news) {
			NewDTO dtonew = newConverter.toDto(item);
			models.add(dtonew);
		}
		return models;
	}

	@Override
	public int totalItems() {
		return (int)newRepository.count();
	}

	@Override
	public NewDTO findById(long id) {
		NewsEntity entity = newRepository.findOne(id);
		return newConverter.toDto(entity);
	}

	@Override
	@Transactional
	public NewDTO insert(NewDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCatagoryCode());
		NewsEntity newEntity = newConverter.toEntity(dto);
		newEntity.setCategory(category);
		return newConverter.toDto(newRepository.save(newEntity));
	}

	@Override
	@Transactional
	public NewDTO update(NewDTO dto) {
		NewsEntity oldNew = newRepository.findOne(dto.getId());
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCatagoryCode());
		oldNew.setCategory(category);
		NewsEntity updateNew = newConverter.toEntity(oldNew, dto);
		return newConverter.toDto(newRepository.save(updateNew));
	}

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCatagoryCode());
		NewsEntity newEntity = new NewsEntity();
		if(dto.getId() != null) {
			NewsEntity oldNew = newRepository.findOne(dto.getId());
			oldNew.setCategory(category);
			newEntity = newConverter.toEntity(oldNew, dto);
		}else {
			newEntity = newConverter.toEntity(dto);
			newEntity.setCategory(category);
		}
		return newConverter.toDto(newRepository.save(newEntity));
	}





}
