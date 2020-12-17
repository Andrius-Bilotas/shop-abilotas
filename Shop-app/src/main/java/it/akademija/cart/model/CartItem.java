package it.akademija.cart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.akademija.product.model.Product;

@Entity
@Table(name = "Cart_items")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "cart_id")
	private CartEntity cart;
	
	private int quantityInCart;
	
	public CartItem() {
		this.quantityInCart = 1;
	}
	
	public CartItem(Product product, CartEntity cart) {
		this.product = product;
		this.cart = cart;
		this.quantityInCart = 1;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public CartEntity getCart() {
		return cart;
	}
	public void setCart(CartEntity cart) {
		this.cart = cart;
	}
	public int getQuantityInCart() {
		return quantityInCart;
	}
	public void setQuantityInCart(int quantityInCart) {
		this.quantityInCart = quantityInCart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		CartItem other = (CartItem) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
	
}
