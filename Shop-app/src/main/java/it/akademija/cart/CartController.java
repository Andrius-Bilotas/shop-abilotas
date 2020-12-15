package it.akademija.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.akademija.cart.model.CreateCartCommand;
import it.akademija.cart.service.CartService;
import it.akademija.product.model.Product;

@RestController
@RequestMapping(value = "/api/users/{userName}/cart-products")
public class CartController {
	
	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CreateCartCommand> getCartProducts(@PathVariable final String userName) {
		return cartService.getCartProducts(userName).stream()
													.map(product -> new CreateCartCommand(product.getId(), product.getTitle(), 
															product.getProductDetails().getImage(), product.getProductDetails().getDescription(), product.getPrice(), product.getQuantity()))
													.collect(Collectors.toList());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public List<CreateCartCommand> addCartProduct(@RequestBody final CreateCartCommand cmd, @PathVariable final String userName) {
		System.out.println("User name in Cart Controller: " + userName);
		return cartService.addCartProduct(userName, cmd).stream()
				.map(product -> new CreateCartCommand(product.getId(), product.getTitle(), 
						product.getProductDetails().getImage(), product.getProductDetails().getDescription(), product.getPrice(), product.getQuantity()))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(path = "/{productID}", method = RequestMethod.DELETE)
	public List<CreateCartCommand> removeCartProduct(@PathVariable("userName") final String userName, @PathVariable("productID") final String id) {
		//cartService.removeCartProduct(userName, id);
		return cartService.deleteCartProduct(userName, id).stream()
				.map(product -> new CreateCartCommand(product.getId(), product.getTitle(), 
						product.getProductDetails().getImage(), product.getProductDetails().getDescription(), product.getPrice(), product.getQuantity()))
				.collect(Collectors.toList());
	}
	
}
