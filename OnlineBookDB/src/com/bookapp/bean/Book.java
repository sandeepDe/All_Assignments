package com.bookapp.bean;

public class Book {
	private String title;
	private String author;
	private String category;
	private int bookid;
	private int price;

	public Book() {
		super();
	}

	public Book(int bookid, int price, String title, String author, String category) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.bookid = bookid;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", bookid=" + bookid
				+ ", price=" + price + "]";
	}

}
