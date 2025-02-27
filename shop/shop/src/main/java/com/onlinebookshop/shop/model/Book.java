//package com.onlinebookshop.shop.model;
//
//public class Book {
//	 
//	private int id;
//	private String title;
//	private double price;
//	private int authorId;
//	public Book(int id, String title, double price, int authorId) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.price = price;
//		this.authorId = authorId;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public double getPrice() {
//		return price;
//	}
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	public int getAuthorId() {
//		return authorId;
//	}
//	public void setAuthorId(int authorId) {
//		this.authorId = authorId;
//	}
//
//}




package com.onlinebookshop.shop.model;

public class Book {
    private int id;
    private String title;
    private double price;
    private Integer authorId; // Change to Integer to allow null

    public Book(int id, String title, double price, Integer authorId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.authorId = authorId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", authorId=" + authorId + "]";
	}
}
