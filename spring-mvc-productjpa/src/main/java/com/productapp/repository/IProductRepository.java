package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
	
	



    List<Product> findByBrand(String brand) ;
    List<Product>findByPriceLessThan(double price) ;
    List<Product>findByBrandStartingWith(String brand );
    
    @Query("from Product p where p.category = ?1 or p.brand= ?1")
    List<Product> findByChoice(String choice);

}
