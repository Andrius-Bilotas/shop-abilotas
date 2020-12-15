package it.akademija.cart.dao;

import java.util.Set;

import it.akademija.cart.model.CartEntity;
import it.akademija.product.model.Product;

public interface CartDao {
	
	Set<Product> getCartProducts(String userName);
	
	CartEntity addCartProduct(Product product, String userName);
	
	CartEntity removeCartProduct(String userName, Product product);
	
	CartEntity getCartByUsername(String userName);

}
