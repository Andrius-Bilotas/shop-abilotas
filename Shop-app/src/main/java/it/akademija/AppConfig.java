package it.akademija;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//import it.akademija.Product;
//import it.akademija.ServiceC;


@Configuration
public class AppConfig {
	
	@Bean
	public ServiceC serviceCBean() {
		return new ServiceC();
	}
	
	
	@Qualifier("product")
	@Bean
	public Product product1() {
		return new Product("Samsung S7", "/samsungS7.jpg", "Good phone", 20);
	}
	
	@Qualifier("product")
	@Bean
	public Product product2() {
		return new Product("IPhone 10", "/iphone10.jpg", "A phone", 35);
	}
	
	@Qualifier("product")
	@Bean
	public Product product3() {
		return new Product("Huawei Honor X10", "/honorx10.jpg", "Bad phone", 15);
	}
}