package com.kh.model.vo;

public class RentArray {
	private int bookNumber;
	private int memberNumber;
	private String bookName;
	private String bookAuthor;
	
	public RentArray() {
		super();
	}

	public RentArray(int bookNumber, int memberNumber) {
		super();
		this.bookNumber = bookNumber;
		this.memberNumber = memberNumber;
	}

	public RentArray(int bookNumber, int memberNumber, String bookName, String bookAuthor) {
		super();
		this.bookNumber = bookNumber;
		this.memberNumber = memberNumber;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	@Override
	public String toString() {
		return "대여목록 : 책 번호 : " + bookNumber + ", 회원번호 : " + memberNumber + ", 책 이름 : " + bookName
				+ ", 책 저자 : " + bookAuthor ;
	}
	
	
	
}
