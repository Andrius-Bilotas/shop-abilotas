package it.akademija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.akademija.dao.CartDao;
import it.akademija.model.CartProduct;
import it.akademija.model.CreateCartCommand;

@RestController
@RequestMapping(value = "/api/users/{userName}/cart-products")
public class CartController {
	
	private final CartDao cartDao;
	
	@Autowired
	public CartController(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CartProduct> getCartProducts(@PathVariable final String userName) {
		return cartDao.getCartProducts(userName);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public List<CartProduct> addCartProduct(@RequestBody final CreateCartCommand cmd, @PathVariable final String userName) {
		cartDao.addCartProduct(userName, new CartProduct(cmd.getId(), cmd.getTitle(), cmd.getImage()));
		return cartDao.getCartProducts(userName);
	}
	
	@RequestMapping(path = "/{productID}", method = RequestMethod.DELETE)
	public List<CartProduct> removeCartProduct(@PathVariable("userName") final String userName, @PathVariable("productID") final String id) {
		cartDao.removeCartProduct(userName, id);
		return cartDao.getCartProducts(userName);
	}
	
}
