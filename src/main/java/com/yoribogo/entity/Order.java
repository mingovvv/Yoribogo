package com.yoribogo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int recipeId;
	private String chapter;
	private String image;
	private String content;
	
	
	public Order() {
		// TODO Auto-generated constructor stub
	}


	public Order(int recipeId, String chapter, String image, String content) {
		super();
		this.recipeId = recipeId;
		this.chapter = chapter;
		this.image = image;
		this.content = content;
	}


	public int getRecipeId() {
		return recipeId;
	}


	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}


	public String getChapter() {
		return chapter;
	}


	public void setChapter(String chapter) {
		this.chapter = chapter;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Order [recipeId=" + recipeId + ", chapter=" + chapter + ", image=" + image + ", content=" + content
				+ "]";
	}
	
	
	
}
