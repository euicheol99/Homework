package com.kh.model.vo;

public class Member {
	private int memberNum;
	private String memberId;
	private String memberPassword;
	private String memberName;
	
	public Member() {
		super();
	}
	
	
	public Member(int membernum, String memberid, String memberpassword, String membername) {
		super();
		this.memberNum = membernum;
		this.memberId = memberid;
		this.memberPassword = memberpassword;
		this.memberName = membername;
	}



	public Member(String memberid, String memberpassword, String membername) {
		super();
		this.memberId = memberid;
		this.memberPassword = memberpassword;
		this.memberName = membername;
	}


	public int getMemberNum() {
		return memberNum;
	}


	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPassword() {
		return memberPassword;
	}


	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	@Override
	public String toString() {
		return "Member [memberNum=" + memberNum + ", memberId=" + memberId + ", memberPassword=" + memberPassword
				+ ", memberName=" + memberName + "]";
	}


	
	
	
	
	
}
