package it.akademija.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import it.akademija.model.CartProduct;
import it.akademija.model.Product;

@Repository
public class InMemoryCartDAO implements CartDao {
	
	private final Map<String, List<CartProduct>> cartProducts = new ConcurrentHashMap<>();

	@Override
	public List<CartProduct> getCartProducts(String userName) {
		// TODO Auto-generated method stub
		if (!(cartProducts.containsKey(userName))) {
			cartProducts.put(userName, new CopyOnWriteArrayList<>());
			return Collections.unmodifiableList(cartProducts.get(userName));
		} else {
			return Collections.unmodifiableList(cartProducts.get(userName));
		}
	}

	@Override
	public void addCartProduct(String userName, CartProduct cartProduct) {
		// TODO Auto-generated method stub
		cartProducts.get(userName).add(cartProduct);
	}

	@Override
	public void removeCartProduct(String userName, String id) {
		// TODO Auto-generated method stub
		cartProducts.get(userName).remove(Integer.parseInt(id));
	}

}
