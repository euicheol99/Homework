package com.kh.model.vo;

public class Book {
	private int bookNumber;
	private String bookName;
	private String bookAuthor;
	
	public Book() {
		super();
	}

	public Book(int bookNumber, String bookName, String bookAuthor) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	public Book(String bookName, String bookAuthor) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
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
		return "책 번호 : " + bookNumber + ", 책 제목 : " + bookName + ", 저자 : " + bookAuthor ;
	}
	
	
	
	
}
