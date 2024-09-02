package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.NewsEntity;



public interface iNewRepository extends JpaRepository< NewsEntity, Long> {
	
}
