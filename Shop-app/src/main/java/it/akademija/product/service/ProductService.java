package it.akademija.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.product.dao.DBProductDetailsDAO;
import it.akademija.product.dao.ProductDao;
import it.akademija.product.model.CreateProductCommand;
import it.akademija.product.model.Product;
import it.akademija.product.model.ProductDetails;
import it.akademija.product.model.ServiceProduct;

@Service
public class ProductService {
	
	@Autowired
	@Qualifier("ProductsFromDatabase")
	private ProductDao productDao;
	
	@Autowired
	private DBProductDetailsDAO detailsDao;
	
	@Transactional
	public List<ServiceProduct> getProducts() {
		return productDao.getProducts().stream()
								.map(productsFromDb -> new ServiceProduct(productsFromDb.getTitle(), productsFromDb.getProductDetails().getImage(), 
										productsFromDb.getProductDetails().getDescription(), productsFromDb.getPrice(), productsFromDb.getQuantity(), productsFromDb.getId()))
								.collect(Collectors.toList());
	}
	
	@Transactional
	public void createProduct(CreateProductCommand cmd) {
		productDao.createProduct(new Product(cmd.getTitle(), cmd.getPrice(), cmd.getQuantity(), new ProductDetails(cmd.getImage(), cmd.getDescription())));
	}
	
	@Transactional
	public ServiceProduct getSingleProduct(String id) {
		var product = productDao.getSingleProduct(id);
		return new ServiceProduct(product.getTitle(), product.getProductDetails().getImage(), 
				product.getProductDetails().getDescription(), product.getPrice(), product.getQuantity(), product.getId());
	}
	
	@Transactional
	public void updateProduct(ServiceProduct serviceProduct) {
		var productDetails = new ProductDetails(serviceProduct.getImage(), serviceProduct.getDescription());
		var product = new Product(serviceProduct.getTitle(), serviceProduct.getPrice(), serviceProduct.getQuantity());
		product.setId(serviceProduct.getId());
		productDetails.setId(serviceProduct.getId());
		var savedDetails = detailsDao.save(productDetails);
		product.setProductDetails(productDetails);
		productDao.updateProduct(product);
	}
	
	@Transactional
	public List<ServiceProduct> deleteProduct(String id) {
		productDao.deleteProduct(id);
		return productDao.getProducts().stream()
										.map(product -> new ServiceProduct(product.getTitle(), product.getProductDetails().getImage(), product.getProductDetails().getDescription(),
												product.getPrice(), product.getQuantity(), product.getId()))
										.collect(Collectors.toList());
	}
	
	@Transactional
	public List<ServiceProduct> findProductByTitle(String title) {
		return productDao.getProductsByTitle(title).stream()
				.map(product -> new ServiceProduct(product.getTitle(), product.getProductDetails().getImage(), product.getProductDetails().getDescription(),
						product.getPrice(), product.getQuantity(), product.getId()))
				.collect(Collectors.toList());						
	}

}
