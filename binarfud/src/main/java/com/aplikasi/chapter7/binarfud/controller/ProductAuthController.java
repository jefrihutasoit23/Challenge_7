package com.aplikasi.chapter7.binarfud.controller;

import com.aplikasi.chapter7.binarfud.entity.Product;
import com.aplikasi.chapter7.binarfud.repository.ProductRepository;
import com.aplikasi.chapter7.binarfud.service.ProductService;
import com.aplikasi.chapter7.binarfud.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/productsAuth")
public class ProductAuthController {

    @Autowired
    private ProductService productService;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public TemplateResponse response;

    @PostMapping(value = {"/add","/add/"})
    public ResponseEntity<Map> addProduct(@RequestBody Product product){
        try {
            return new ResponseEntity<Map>(productService.addProduct(product), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @PutMapping(value = {"/update","/update/"})
    public ResponseEntity<Map> updateProduct(@RequestBody Product product) {
        try {
            return new ResponseEntity<Map>(productService.updateProduct(product), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @DeleteMapping(value = {"/delete","/delete/"})
    public ResponseEntity<Map> deleteProduct(@RequestBody Product request) {
        try {
            return new ResponseEntity<Map>(productService.deleteProduct(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }
}

