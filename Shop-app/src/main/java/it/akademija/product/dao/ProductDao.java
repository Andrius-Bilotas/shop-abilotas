package it.akademija.product.dao;

import java.util.List;

import it.akademija.product.model.Product;

public interface ProductDao {
	
	List<Product> getProducts();
	
	void createProduct(Product product);
	
	void deleteProduct(String id);
	
	void updateProduct(Product product);
	
	Product getSingleProduct(String id);
	
	List<Product> getProductsByTitle(String title);
}
