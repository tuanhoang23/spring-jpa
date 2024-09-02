package com.spring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.spring.DTO.NewDTO;



public interface iNewsService {
	
	List<NewDTO> findAll(Pageable pageable);
	int totalItems();
	NewDTO findById(long id);
	NewDTO insert (NewDTO dto);
	NewDTO update (NewDTO dto);
	NewDTO save (NewDTO dto);
}
