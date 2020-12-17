package it.akademija.cart.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.cart.dao.CartDao;
import it.akademija.cart.model.CartItem;
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
	public List<CreateCartCommand> getCartProducts(String userName) {
		return cartDao.getCartProducts(userName).getCartItems().stream()
				.map(product -> new CreateCartCommand(product.getProduct().getId(), product.getProduct().getTitle(),
						product.getProduct().getProductDetails().getImage(),
						product.getProduct().getProductDetails().getDescription(), product.getProduct().getPrice(),
						product.getProduct().getQuantity(), product.getQuantityInCart()))
				.collect(Collectors.toList());
	}

	@Transactional
	public List<CreateCartCommand> addCartProduct(String userName, CreateCartCommand cmd) {
		var product = productDao.getSingleProduct(String.valueOf(cmd.getId()));
		cartDao.addCartProduct(product, userName);
		//var productCarts = product.getCartItems();
		//productCarts.add(new CartItem(product, cartDao.addCartProduct(product, userName)));
		//product.setCartItems(productCarts);
		//productDao.updateProduct(product);
		return cartDao.getCartProducts(userName).getCartItems().stream()
				.map(productFromDb -> new CreateCartCommand(productFromDb.getProduct().getId(),
						productFromDb.getProduct().getTitle(),
						productFromDb.getProduct().getProductDetails().getImage(),
						productFromDb.getProduct().getProductDetails().getDescription(),
						productFromDb.getProduct().getPrice(), productFromDb.getProduct().getQuantity(),
						productFromDb.getQuantityInCart()))
				.collect(Collectors.toList());
	}

	@Transactional
	public List<CreateCartCommand> deleteCartProduct(String userName, String productId) {
		var product = productDao.getSingleProduct(productId);
		cartDao.removeCartProduct(userName,product);
		return cartDao.getCartProducts(userName).getCartItems().stream()
				.map(productFromDb -> new CreateCartCommand(productFromDb.getProduct().getId(),
						productFromDb.getProduct().getTitle(),
						productFromDb.getProduct().getProductDetails().getImage(),
						productFromDb.getProduct().getProductDetails().getDescription(),
						productFromDb.getProduct().getPrice(), productFromDb.getProduct().getQuantity(),
						productFromDb.getQuantityInCart()))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public List<CreateCartCommand> updateCartProductQuantity(String userName, String productId, int quantity) {
		var product = productDao.getSingleProduct(productId);
		cartDao.updateQuantityInCart(userName, product, quantity);
		return cartDao.getCartProducts(userName).getCartItems().stream()
				.map(productFromDb -> new CreateCartCommand(productFromDb.getProduct().getId(),
						productFromDb.getProduct().getTitle(),
						productFromDb.getProduct().getProductDetails().getImage(),
						productFromDb.getProduct().getProductDetails().getDescription(),
						productFromDb.getProduct().getPrice(), productFromDb.getProduct().getQuantity(),
						productFromDb.getQuantityInCart()))
				.collect(Collectors.toList());
	}

}
