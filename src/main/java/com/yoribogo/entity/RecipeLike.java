package com.yoribogo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
 
@Entity
public class RecipeLike implements Serializable{
	
	@Id
	private int recipeId;
	@Id
	private String memberId;
	
	public RecipeLike() {
		// TODO Auto-generated constructor stub
	}

	public RecipeLike(int recipeId, String memberId) {
		super();
		this.recipeId = recipeId;
		this.memberId = memberId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
