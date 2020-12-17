package it.akademija.cart.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.cart.model.CartEntity;
import it.akademija.cart.model.CartItem;
import it.akademija.product.model.Product;



@Qualifier("CartFromDB")
public interface DBCartDAO extends JpaRepository<CartEntity, String>, CartDao {
	
	default CartEntity getCartProducts(String userName) {
		if (this.findById(userName).isEmpty()) {
			this.save(new CartEntity(userName));
			return this.findById(userName).get();
		} else {
			return this.findById(userName).get();
		}
	}
	
	default CartEntity addCartProduct(Product product, String userName) {
		var cart = this.findById(userName).get();
		var cartProducts = cart.getCartItems();
		cartProducts.add(new CartItem(product, cart));
		cart.setCartItems(cartProducts);
		return this.save(cart);
	}
	
	default CartEntity removeCartProduct(String userName, Product product) {
		var cart = this.findById(userName).get();
		var cartProducts = cart.getCartItems();
		cartProducts.remove(new CartItem(product, cart));
		cart.setCartItems(cartProducts);
		return this.save(cart);
	}
	
	default CartEntity getCartByUsername(String userName) {
		return this.findById(userName).orElse(null);
	}
	
	default CartEntity updateQuantityInCart(String userName, Product product, int quantity) {
		var cart = this.findById(userName).get();
		var cartItems = cart.getCartItems();
		cartItems.stream()
					.filter(item -> item.equals(new CartItem(product, cart)))
					.forEach(item -> item.setQuantityInCart(quantity));
		return this.save(cart);
	}
}
