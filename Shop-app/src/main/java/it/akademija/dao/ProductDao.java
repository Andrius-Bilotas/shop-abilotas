package it.akademija.dao;

import java.util.List;

import it.akademija.model.Product;

public interface ProductDao {
	
	List<Product> getProducts();
	
	void createProduct(Product product);
	
	void deleteProduct(String id);
	
	void updateProduct(Product product);
	
	Product getSingleProduct(String id);
}
