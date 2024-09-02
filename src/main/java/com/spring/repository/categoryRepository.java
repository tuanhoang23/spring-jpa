package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.CategoryEntity;

public interface categoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);
}
