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
public class Community {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String memberId;
	private String image;
	private String content;
	@Column(insertable=false)
	private Date regDate;
	private int cnt;
	
	@Transient //값을 데이터에 저장하지 않으려는 경우에 사용됨
	private List<CommunityComment> comments;
	
	public Community() {
		// TODO Auto-generated constructor stub
	}
	
	public Community(int id, String memberId, String image, String content, Date regDate, int cnt,
			List<CommunityComment> comments) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.image = image;
		this.content = content;
		this.regDate = regDate;
		this.cnt = cnt;
		this.comments = comments;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public List<CommunityComment> getComments() {
		return comments;
	}

	public void setComments(List<CommunityComment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Community [id=" + id + ", memberId=" + memberId + ", image=" + image + ", content=" + content
				+ ", regDate=" + regDate + ", cnt=" + cnt + ", comments=" + comments + "]";
	}

}
