package com.yoribogo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MemberRoleId implements Serializable{
	private String memberId;
	private String roleId;
	
	public MemberRoleId() {
		// TODO Auto-generated constructor stub
	}

	public MemberRoleId(String memberId, String roleId) {
		this.memberId = memberId;
		this.roleId = roleId;
		
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "MerberRoleId [memberId=" + memberId + ", roleId=" + roleId + "]";
	}	
	
	
}
