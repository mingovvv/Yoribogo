package com.yoribogo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	private String id;
	private String pwd;
	private String name;
	private String nickname;
	private String email;
	private Date regDate;
	private String photo;
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Member(String id, String pwd, String name, String nickname, String email, String photo) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.photo = photo;
	}


	public Member(String id, String pwd, String name, String nickname, String email, Date regDate, String photo) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.regDate = regDate;
		this.photo = photo;
	}





	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


/*	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}*/


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Member [nickname=" + nickname + ", regDate=" + regDate + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", photo=" + photo + "]";
	}
	
	
	
}
