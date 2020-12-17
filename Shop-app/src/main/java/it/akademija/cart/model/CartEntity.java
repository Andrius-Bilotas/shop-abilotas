package it.akademija.cart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import it.akademija.product.model.Product;

@Entity
public class CartEntity {
	
	@Id
	private String username;
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL)
	private Set<CartItem> cartItems;

	public CartEntity() {
		super();
		this.cartItems = new HashSet<>();
	}
	
	public CartEntity(String username) {
		super();
		this.username = username;
		this.cartItems = new HashSet<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartEntity other = (CartEntity) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	

	
}
