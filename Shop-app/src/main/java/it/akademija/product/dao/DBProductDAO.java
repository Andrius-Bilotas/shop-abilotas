package it.akademija.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	@Query("select p from Product p where p.title like %:title%")
	List<Product> getProductsByTitle(@Param("title") String title); //{
		//return this.findByTitle(title);
	//}
	
	List<Product> findByTitle(String title);

}
