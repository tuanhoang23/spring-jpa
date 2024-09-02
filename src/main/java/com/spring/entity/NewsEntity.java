package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="new")
public class NewsEntity extends BaseEntity {
	

	
	@Column(name ="title")
	private String title;
	
	@Column(name ="thumbnail")
	private String thumbnail;
	
	@Column(name ="sortdecription", columnDefinition = "TEXT")
	private String sortDecription;
	
	@Column(name ="content", columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail ) {
		this.thumbnail = thumbnail;
	}

	public String getSortDecription() {
		return sortDecription;
	}

	public void setSortDecription(String sortDecription) {
		this.sortDecription = sortDecription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
