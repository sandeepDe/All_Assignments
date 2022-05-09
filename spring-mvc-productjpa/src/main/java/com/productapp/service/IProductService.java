package com.productapp.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;


public interface IProductService {
    
    void addProduct(Product product);
    void deleteProduct(int productID);
    void  updateProduct(Product product);

    //derived Queries

    List<Product> getAll();
    Product getById(int productId) throws ProductNotFoundException;
     List<Product> getByBrand(String brand) throws ProductNotFoundException;
    List<Product>getByLesserPrice(double price) throws ProductNotFoundException;
    List<Product>getByBrandStarting(String brand )throws ProductNotFoundException;

    
    List<Product> findByChoice(String choice);

}