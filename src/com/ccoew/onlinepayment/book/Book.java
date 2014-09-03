package com.ccoew.onlinepayment.book;

public class Book {

	private int bookCode;
	private String title;
	private String author;
	private String publication;
	private double price;
	private float rating;
	private int quantity;

	public Book(int bookCode, String title, String author, String publication,
			double price, float rating, int quantity) {
		this.bookCode = bookCode;
		this.title = title;
		this.author = author;
		this.publication = publication;
		this.price = price;
		this.rating = rating;
		this.quantity = quantity;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
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

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", title=" + title + ", author="
				+ author + ", publication=" + publication + ", price=" + price
				+ ", rating=" + rating + ", quantity=" + quantity + "]";
	}

}
