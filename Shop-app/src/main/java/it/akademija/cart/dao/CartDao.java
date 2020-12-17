package it.akademija.cart.dao;

import java.util.Set;

import it.akademija.cart.model.CartEntity;
import it.akademija.product.model.Product;

public interface CartDao {
	
	CartEntity getCartProducts(String userName);
	
	CartEntity addCartProduct(Product product, String userName);
	
	CartEntity removeCartProduct(String userName, Product product);
	
	CartEntity getCartByUsername(String userName);
	
	CartEntity updateQuantityInCart(String userName, Product product, int quantity);

}
