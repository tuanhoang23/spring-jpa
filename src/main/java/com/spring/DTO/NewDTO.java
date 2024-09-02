package com.spring.DTO;

public class NewDTO extends AbstractDTO<NewDTO> {
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private long catagory_Id;
	private String catagoryCode;
	
	public NewDTO() {
		super();
	}

	public NewDTO(String title, String thumbnail, String shortDescription, String content, long catagory_Id) {
		super();
		this.title = title;
		this.thumbnail = thumbnail;
		this.shortDescription = shortDescription;
		this.content = content;
		this.catagory_Id = catagory_Id;
	}
	public String getCatagoryCode() {

		return catagoryCode;
	}
	public void setCatagoryCode(String catagoryCode) {

		this.catagoryCode = catagoryCode;
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
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getCatagory_Id() {
		return catagory_Id;
	}
	public void setCatagory_Id(long catagory_Id) {
		this.catagory_Id = catagory_Id;
	}
}
