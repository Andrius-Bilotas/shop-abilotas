package it.akademija.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.dao.ProductDao;
import it.akademija.model.CreateProductCommand;
import it.akademija.model.Product;
import it.akademija.model.ServiceProduct;

@Service
public class ProductService {
	
	@Autowired
	@Qualifier("ProductsFromDatabase")
	private ProductDao productDao;
	
	@Transactional
	public List<ServiceProduct> getProducts() {
		return productDao.getProducts().stream()
								.map(productsFromDb -> new ServiceProduct(productsFromDb.getTitle(), productsFromDb.getImage(), 
										productsFromDb.getDescription(), productsFromDb.getPrice(), productsFromDb.getQuantity(), productsFromDb.getId()))
								.collect(Collectors.toList());
	}
	
	@Transactional
	public void createProduct(CreateProductCommand cmd) {
		productDao.createProduct(new Product(cmd.getTitle(), cmd.getImage(), 
				cmd.getDescription(), cmd.getPrice(), cmd.getQuantity()));
	}
	
	@Transactional
	public ServiceProduct getSingleProduct(String id) {
		var product = productDao.getSingleProduct(id);
		return new ServiceProduct(product.getTitle(), product.getImage(), 
				product.getDescription(), product.getPrice(), product.getQuantity(), product.getId());
	}
	
	@Transactional
	public void updateProduct(ServiceProduct serviceProduct) {
		productDao.updateProduct(productDao.getSingleProduct(String.valueOf(serviceProduct.getId())));
	}

}
