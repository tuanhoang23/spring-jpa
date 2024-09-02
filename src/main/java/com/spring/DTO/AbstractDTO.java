package com.spring.DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractDTO<T> {
	private Long id;
	private Timestamp createAt;
	private Timestamp modifileAt;
	private String createBy;
	private String modifileBy;
	private long[] ids;
	private List<T> result = new ArrayList<>();
	private Integer page;
	private Integer limit;
	private Integer totalPages;
	private Integer totalItems;
	private String sortName;
	private String sortBy;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public AbstractDTO() {
		super();
	}
	
	public AbstractDTO(long id, Timestamp createAt, Timestamp modifileAt, String createBy, String modifileBy) {
		super();
		this.id = id;
		this.createAt = createAt;
		this.modifileAt = modifileAt;
		this.createBy = createBy;
		this.modifileBy = modifileBy;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	public Timestamp getModifileAt() {
		return modifileAt;
	}
	public void setModifileAt(Timestamp modifileAt) {
		this.modifileAt = modifileAt;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifileBy() {
		return modifileBy;
	}
	public void setModifileBy(String modifileBy) {
		this.modifileBy = modifileBy;
	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
}
