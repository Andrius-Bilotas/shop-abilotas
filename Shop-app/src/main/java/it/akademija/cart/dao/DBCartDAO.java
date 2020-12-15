package it.akademija.cart.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.cart.model.CartEntity;
import it.akademija.product.model.Product;



@Qualifier("CartFromDB")
public interface DBCartDAO extends JpaRepository<CartEntity, String>, CartDao {
	
	default Set<Product> getCartProducts(String userName) {
		if (this.findById(userName).isEmpty()) {
			this.save(new CartEntity(userName));
			return this.findById(userName).get().getCartProducts();
		} else {
			return this.findById(userName).get().getCartProducts();
		}
	}
	
	default CartEntity addCartProduct(Product product, String userName) {
		var cart = this.findById(userName).get();
		var cartProducts = cart.getCartProducts();
		cartProducts.add(product);
		cart.setCartProducts(cartProducts);
		return this.save(cart);
	}
	
	default CartEntity removeCartProduct(String userName, Product product) {
		var cart = this.findById(userName).get();
		var cartProducts = cart.getCartProducts();
		cartProducts.remove(product);
		cart.setCartProducts(cartProducts);
		return this.save(cart);
	}
	
	default CartEntity getCartByUsername(String userName) {
		return this.findById(userName).orElse(null);
	}
}
