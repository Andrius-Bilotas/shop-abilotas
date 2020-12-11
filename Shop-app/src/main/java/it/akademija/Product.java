package it.akademija;

public class Product {
	private String title;
	private String image;
	private String description;
	private int quantity;
	
	public Product(String title, String image, String description, int quantity) {
		super();
		this.title = title;
		this.image = image;
		this.description = description;
		this.quantity = quantity;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
