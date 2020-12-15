package it.akademija.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.product.model.ProductDetails;

public interface DBProductDetailsDAO extends JpaRepository<ProductDetails, Integer> {

}
