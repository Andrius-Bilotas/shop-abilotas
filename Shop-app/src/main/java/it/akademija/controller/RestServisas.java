package it.akademija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.akademija.Product;
import it.akademija.ServiceC;

@RestController
public class RestServisas {
	
	@Autowired
	private ServiceC serviceC;
	
	@RequestMapping("/hello")
    String hello() {
        return "Hello World!";
    }
	
	@RequestMapping("/productsCollection")
	String getProductsCollection() {
		String text = "";
		for (int i = 0; i < serviceC.getProducts().size(); i++) {
			text = text + ((Product)serviceC.getProducts().get(i)).getTitle() + " ";
		}
		return text;
	}
}
