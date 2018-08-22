package com.yoribogo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false)
	private int id;
	private String memberId;
	private String fname;

	private int recipeId;
	
	@Transient
	private Recipe recipe;
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public Ingredient(int id, String memberId, String fname, int recipeId, Recipe recipe) {
		this.id = id;
		this.memberId = memberId;
		this.fname = fname;
		this.recipeId = recipeId;
		this.recipe = recipe;
	}

	public Ingredient(String memberId, String fname, int recipeId, Recipe recipe) {
		this.memberId = memberId;
		this.fname = fname;
		this.recipeId = recipeId;
		this.recipe = recipe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getmemberId() {
		return memberId;
	}

	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	
	
	
	
	
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", memberId=" + memberId + ", fname=" + fname + ", recipeId=" + recipeId
				+ ", recipe=" + recipe + "]";
	}
	
	
	
	
	
}
