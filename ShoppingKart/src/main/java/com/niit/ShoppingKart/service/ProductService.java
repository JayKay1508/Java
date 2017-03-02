package com.niit.ShoppingKart.service;

import java.util.List;

import com.niit.ShoppingKart.model.Product;

public interface ProductService {
Product saveProduct(Product product);
List<Product> getAllProducts();
Product getProductById(int id);
void deleteProduct(int id);
void updateProduct(Product product);
}
