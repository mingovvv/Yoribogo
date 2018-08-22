package com.yoribogo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.ibatis.annotations.Update;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(updatable=false)
	private int recipeId;
	private int chapter;
	private String image;
	private String content;
	
	@Transient
	private Recipe recipe;
	
	public FoodOrder() {
		// TODO Auto-generated constructor stub
	}

	public FoodOrder(int id, int recipeId, int chapter, String image, String content, Recipe recipe) {
		super();
		this.id = id;
		this.recipeId = recipeId;
		this.chapter = chapter;
		this.image = image;
		this.content = content;
		this.recipe = recipe;
	}

	public FoodOrder(int recipeId, int chapter, String image, String content, Recipe recipe) {
		super();
		this.recipeId = recipeId;
		this.chapter = chapter;
		this.image = image;
		this.content = content;
		this.recipe = recipe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getChapter() {
		return chapter;
	}

	public void setChapter(int chapter) {
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

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", recipeId=" + recipeId + ", chapter=" + chapter + ", image=" + image
				+ ", content=" + content + "]";
	}
	
}
