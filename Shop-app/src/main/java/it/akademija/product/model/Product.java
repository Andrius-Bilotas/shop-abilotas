package it.akademija.product.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import it.akademija.cart.model.CartEntity;

@Entity
public final class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private double price;
	private int quantity;
	
	@OneToOne(cascade= {CascadeType.PERSIST}, orphanRemoval=true)
	@JoinColumn(name="productDetails_id")
	private ProductDetails productDetails;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH})
	@JoinTable(name="Cart_products",
	joinColumns=@JoinColumn(name="Product_id"),
	inverseJoinColumns=@JoinColumn(name="Cart_owner"))
	private Set<CartEntity> carts;
	
	public Product() {}
	
	public Product(String title, double price, int quantity) {
		super();
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.carts = new HashSet<>();
	}
	
	public Product(String title, double price, int quantity, ProductDetails productDetails) {
		super();
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.productDetails = productDetails;
		this.carts = new HashSet<>();
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

	public Set<CartEntity> getCarts() {
		return carts;
	}

	public void setCarts(Set<CartEntity> carts) {
		this.carts = carts;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	
	
	
	
}
