package com.aplikasi.chapter7.binarfud.service;

import com.aplikasi.chapter7.binarfud.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Map addProduct(Product product);
    Map updateProduct(Product product);
    Map deleteProduct(Product product);
    Map getByID(Long product);
    List<Product> getAvailableProducts();
}
