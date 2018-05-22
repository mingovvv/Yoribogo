package com.yoribogo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipeId;
	private String fname;
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public Ingredient(int recipeId, String fname) {
		super();
		this.recipeId = recipeId;
		this.fname = fname;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "Ingredient [recipeId=" + recipeId + ", fname=" + fname + "]";
	}
	
	
	
	
}
