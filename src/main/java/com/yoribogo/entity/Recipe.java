package com.yoribogo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String representativeImage;
	private String sortNational;
	private String sortTime;
	private String sortSituation;
	private String ggulTip;
	@Column(insertable=false)
	private Date regDate;
	private String memberId;
	
	
	
	@Transient 
	private List<RecipeComment> comments;
	
	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	public Recipe(int id, String title, String description, String representativeImage, String sortNational,
			String sortTime, String sortSituation, String ggulTip, Date regDate, String memberId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.representativeImage = representativeImage;
		this.sortNational = sortNational;
		this.sortTime = sortTime;
		this.sortSituation = sortSituation;
		this.ggulTip = ggulTip;
		this.regDate = regDate;
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRepresentativeImage() {
		return representativeImage;
	}

	public void setRepresentativeImage(String representativeImage) {
		this.representativeImage = representativeImage;
	}

	public String getSortNational() {
		return sortNational;
	}

	public void setSortNational(String sortNational) {
		this.sortNational = sortNational;
	}

	public String getSortTime() {
		return sortTime;
	}

	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	public String getSortSituation() {
		return sortSituation;
	}

	public void setSortSituation(String sortSituation) {
		this.sortSituation = sortSituation;
	}

	public String getGgulTip() {
		return ggulTip;
	}

	public void setGgulTip(String ggulTip) {
		this.ggulTip = ggulTip;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", description=" + description + ", representativeImage="
				+ representativeImage + ", sortNational=" + sortNational + ", sortTime=" + sortTime + ", sortSituation="
				+ sortSituation + ", ggulTip=" + ggulTip + ", regDate=" + regDate + ", memberId=" + memberId + "]";
	}

	public List<RecipeComment> getComments() {
		return comments;
	}

	public void setComments(List<RecipeComment> comments) {
		this.comments = comments;
		
	}
	
	
	
}
