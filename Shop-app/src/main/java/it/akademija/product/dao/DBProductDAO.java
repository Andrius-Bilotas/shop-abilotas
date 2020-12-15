package it.akademija.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.product.model.Product;

@Qualifier("ProductsFromDatabase")
public interface DBProductDAO extends ProductDao, JpaRepository<Product, Integer> {

	default List<Product> getProducts() {
		return this.findAll();
	}

	default void createProduct(Product product) {
		this.save(product);
	}

	default void deleteProduct(String id) {
		this.deleteById(Integer.parseInt(id));
	}
	
	default void updateProduct(Product product) {
		this.save(product);
	}
	
	default Product getSingleProduct(String id) {
		return this.findById(Integer.parseInt(id)).get();
	}

}
