package it.akademija.dao;

import java.util.List;

import it.akademija.model.CartProduct;
import it.akademija.model.Product;

public interface CartDao {
	
	List<CartProduct> getCartProducts(String userName);
	
	void addCartProduct(String userName, CartProduct cartProduct);
	
	void removeCartProduct(String userName, String id);

}
