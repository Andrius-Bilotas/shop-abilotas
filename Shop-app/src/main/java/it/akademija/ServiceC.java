package it.akademija;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ServiceC {
	
	private List<Object> products;


	public List<Object> getProducts() {
		return products;
	}
	
	@Qualifier("product")
	@Autowired
	public void setProducts(List<Object> products) {
		this.products = products;
	}


	
	
}
