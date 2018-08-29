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
public class CommunityComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String memberId;
	private String content;
	@Column(insertable=false)
	private Date regDate;
	private int communityId;
	
	@Transient //값을 데이터에 저장하지 않으려는 경우에 사용됨
	private Community community;
	
	public CommunityComment() {
		// TODO Auto-generated constructor stub
	}

	public CommunityComment(int id, String memberId, String content, Date regDate, int communityId,
			Community community) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.content = content;
		this.regDate = regDate;
		this.communityId = communityId;
		this.community = community;
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

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	@Override
	public String toString() {
		return "CommunityComment [id=" + id + ", memberId=" + memberId + ", content=" + content + ", regDate=" + regDate
				+ ", communityId=" + communityId + ", community=" + community + "]";
	}

}
