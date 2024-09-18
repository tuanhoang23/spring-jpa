package com.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autuincrement
	private long id;

	public void setId(long id) {
		this.id = id;
	}

	@Column(name ="created_at")
	@CreatedDate
	private Date createdAt;
	
	@Column(name ="created_by")
	@CreatedBy
	private String createdBy;
	
	@Column(name ="modified_at")
	@LastModifiedDate
	private Date modifiedAt;
	
	@Column(name ="modified_by")
	@LastModifiedBy
	private String modifiedBy;
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}


	public long getId() {
		return id;
	}
}
