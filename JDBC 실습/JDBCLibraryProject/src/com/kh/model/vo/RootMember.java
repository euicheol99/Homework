package com.kh.model.vo;

public class RootMember {
	private String rootManagerId;
	private String rootManagerPassword;
	
	
	
	public RootMember() {
		super();
	}



	public RootMember(String rootManagerId, String rootManagerPassword) {
		super();
		this.rootManagerId = rootManagerId;
		this.rootManagerPassword = rootManagerPassword;
	}



	public String getRootManagerId() {
		return rootManagerId;
	}



	public void setRootManagerId(String rootManagerId) {
		this.rootManagerId = rootManagerId;
	}



	public String getRootManagerPassword() {
		return rootManagerPassword;
	}



	public void setRootManagerPassword(String rootManagerPassword) {
		this.rootManagerPassword = rootManagerPassword;
	}



	@Override
	public String toString() {
		return "RootMember [rootManagerId=" + rootManagerId + ", rootManagerPassword=" + rootManagerPassword + "]";
	}
	
	
}
