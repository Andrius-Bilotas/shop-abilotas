package it.akademija.cart.model;

public final class CreateCartCommand {

	private int id;
	private String title;
	private String image;
	private String description;
	private double price;
	private int quantity;
	private int quantityInCart;
	
	public CreateCartCommand() {}

	public CreateCartCommand(int id, String title, String image, String description, double price, int quantity, int quantityInCart) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.quantityInCart = quantityInCart;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantityInCart() {
		return quantityInCart;
	}

	public void setQuantityInCart(int quantityInCart) {
		this.quantityInCart = quantityInCart;
	}
	
	

}
