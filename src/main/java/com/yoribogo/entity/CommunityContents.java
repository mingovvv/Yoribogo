package com.yoribogo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CommunityContents {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int communityId;
	private int index;
	private String subImage;
	private String subContent;
	
	public CommunityContents() {
		// TODO Auto-generated constructor stub
	}

	public CommunityContents(int id, int communityId, int index, String subImage, String subContent) {
		super();
		this.id = id;
		this.communityId = communityId;
		this.index = index;
		this.subImage = subImage;
		this.subContent = subContent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getSubImage() {
		return subImage;
	}

	public void setSubImage(String subImage) {
		this.subImage = subImage;
	}

	public String getSubContent() {
		return subContent;
	}

	public void setSubContent(String subContent) {
		this.subContent = subContent;
	}

	@Override
	public String toString() {
		return "CommunityContents [id=" + id + ", communityId=" + communityId + ", index=" + index + ", subImage="
				+ subImage + ", subContent=" + subContent + "]";
	}
	
}
