package model.entities;

public class Book {
	private String id;
	private String name;
	private int number_of_page;
	private double price;

	public Book() {
		super();
	}

	public Book(String id, String name, int number_of_page, double price) {
		super();
		this.id = id;
		this.name = name;
		this.number_of_page = number_of_page;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber_of_page() {
		return number_of_page;
	}

	public void setNumber_of_page(int number_of_page) {
		this.number_of_page = number_of_page;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", number_of_page=" + number_of_page + ", price=" + price + "]";
	}

}
