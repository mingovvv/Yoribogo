package com.yoribogo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class RecipeComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String memberId;
	private String profile;
	private String content;
	@Column(insertable=false)
	private Date regDate;
	private int recipeId;
	
	@Transient //값을 데이터에 저장하지 않으려는 경우에 사용됨
	private Recipe recipe;
	
	
	public RecipeComment() {
		// TODO Auto-generated constructor stub
	}

	public RecipeComment(int id, String memberId, String profile, String content, Date regDate, int recipeId,
			Recipe recipe) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.profile = profile;
		this.content = content;
		this.regDate = regDate;
		this.recipeId = recipeId;
		this.recipe = recipe;
	}


	public RecipeComment(String memberId, String profile, String content, Date regDate, int recipeId,
			Recipe recipe) {
		super();
		this.memberId = memberId;
		this.profile = profile;
		this.content = content;
		this.regDate = regDate;
		this.recipeId = recipeId;
		this.recipe = recipe;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
		return "RecipeComment [id=" + id + ", memberId=" + memberId + ", profile=" + profile + ", content=" + content + ", regDate="
				+ regDate + ", recipeId=" + recipeId + ", recipe=" + recipe + "]";
	}
	
}
