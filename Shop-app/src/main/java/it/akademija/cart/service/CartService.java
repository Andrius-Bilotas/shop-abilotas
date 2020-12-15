package it.akademija.cart.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.cart.dao.CartDao;
import it.akademija.cart.model.CreateCartCommand;
import it.akademija.product.dao.ProductDao;
import it.akademija.product.model.Product;

@Service
public class CartService {
	
	@Autowired
	@Qualifier("CartFromDB")
	private CartDao cartDao;
	
	@Autowired
	@Qualifier("ProductsFromDatabase")
	private ProductDao productDao;
	
	@Transactional
	public Set<Product> getCartProducts(String userName) {
		return cartDao.getCartProducts(userName);
	}
	
	@Transactional
	public Set<Product> addCartProduct(String userName, CreateCartCommand cmd) {
		var product = productDao.getSingleProduct(String.valueOf(cmd.getId()));
		var productCarts = product.getCarts();
		productCarts.add(cartDao.addCartProduct(product, userName));
		product.setCarts(productCarts);
		productDao.updateProduct(product);
		return cartDao.getCartProducts(userName);
	}
	
	@Transactional
	public Set<Product> deleteCartProduct(String userName, String productId) {
		var product = productDao.getSingleProduct(productId);
		var productCarts = product.getCarts();
		productCarts.remove(cartDao.removeCartProduct(userName, product));
		return cartDao.getCartProducts(userName);
	}

}
