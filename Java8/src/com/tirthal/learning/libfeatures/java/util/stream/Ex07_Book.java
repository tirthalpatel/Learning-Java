package com.tirthal.learning.libfeatures.java.util.stream;

/**
 * Book Model or POJO
 * 
 * @author tirthalp
 */
public class Ex07_Book {

	private String name;
	private String author;
	private int totalPages;
	private double price;
	
	public Ex07_Book(String name, String author, int totalPages, double price) {
		super();
		this.name = name;
		this.author = author;
		this.totalPages = totalPages;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", totalPages=" + totalPages + ", price=" + price
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
