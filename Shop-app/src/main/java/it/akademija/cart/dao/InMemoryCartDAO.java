package it.akademija.cart.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import it.akademija.cart.model.CartEntity;
import it.akademija.product.model.Product;

@Repository
public class InMemoryCartDAO implements CartDao {
	
	private final Map<String, List<Product>> cartProducts = new ConcurrentHashMap<>();

	@Override
	public CartEntity getCartProducts(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartEntity addCartProduct(Product product, String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartEntity removeCartProduct(String userName, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartEntity getCartByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartEntity updateQuantityInCart(String userName, Product product, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

}
