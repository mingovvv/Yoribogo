package com.yoribogo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MemberRole {
	
	@EmbeddedId
	MemberRoleId memberRoleId;
	
	private boolean defaultRole;
	
	public MemberRole() {
		// TODO Auto-generated constructor stub
	}

	public MemberRole(String memberId, String roleId, boolean defaultRole) {
		this.memberRoleId.setMemberId(memberId);
		this.memberRoleId.setRoleId(roleId);
		this.defaultRole = defaultRole;
	}

	public String getMemberId() {
		return memberRoleId.getMemberId();
	}

	public void setMemberId(String memberId) {
		memberRoleId.setMemberId(memberId);
	}

	public String getRoleId() {
		return memberRoleId.getRoleId();
	}

	public void setRoleId(String roleId) {
		memberRoleId.setRoleId(roleId);
	}


	public boolean isDefaultRole() {
		return defaultRole;
	}

	public void setDefaultRole(boolean defaultRole) {
		this.defaultRole = defaultRole;
	}
		
	public MemberRoleId getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(MemberRoleId memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
	
	@Override
	public String toString() {
		return "MemberRole [memberId=" + getMemberId() + ", roleId=" + getRoleId() 
				 + ", defaultRole=" + defaultRole + "]";
	}
	
}
