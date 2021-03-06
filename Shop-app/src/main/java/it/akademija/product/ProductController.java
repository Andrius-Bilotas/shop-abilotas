package it.akademija.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.akademija.product.model.CreateProductCommand;
import it.akademija.product.model.ServiceProduct;
import it.akademija.product.service.ProductService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ServiceProduct> getProducts(@RequestParam final String title) {
		if (title.length() > 0) {
			return productService.findProductByTitle(title);
		} else {
			return productService.getProducts();
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody final CreateProductCommand cmd) {
		productService.createProduct(cmd);
	}

	@RequestMapping(path = "/{productID}", method = RequestMethod.GET)
	public ServiceProduct getProduct(@PathVariable final String productID) {
		return productService.getSingleProduct(productID);
	}

	@RequestMapping(path = "/{productID}", method = RequestMethod.PUT)
	public void updateProduct(@RequestBody final CreateProductCommand cmd, @PathVariable final String productID) {
		var product = new ServiceProduct(cmd.getTitle(), cmd.getImage(), cmd.getDescription(), cmd.getPrice(),
				cmd.getQuantity(), Integer.parseInt(productID));
		productService.updateProduct(product);
	}

	@RequestMapping(path = "/{productID}", method = RequestMethod.DELETE)
	public List<ServiceProduct> deleteProduct(@PathVariable final String productID) {
		return productService.deleteProduct(productID);
	}

	
	/*
	 * @RequestMapping(path = "products", method = RequestMethod.GET) public
	 * List<ServiceProduct> getProductsByTitle() {
	 * 
	 * }
	 */
	 
}
