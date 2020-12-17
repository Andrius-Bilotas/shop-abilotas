package it.akademija.product.dao;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import it.akademija.product.model.Product;

@Repository
public class InMemoryProductDAO implements ProductDao {
	
	private final List<Product> products = new CopyOnWriteArrayList<>();

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(products);
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		products.add(product);
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		int parsedID = Integer.parseInt(id);
		products.remove(parsedID);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product getSingleProduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
