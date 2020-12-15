package it.akademija.cart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import it.akademija.product.model.Product;

@Entity
public class CartEntity {
	
	@Id
	private String username;
	@ManyToMany(mappedBy="carts", cascade = CascadeType.ALL)
	private Set<Product> cartProducts;

	public CartEntity() {
		super();
		this.cartProducts = new HashSet<>();
	}
	
	public CartEntity(String username) {
		super();
		this.username = username;
		this.cartProducts = new HashSet<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Product> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(Set<Product> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
}
