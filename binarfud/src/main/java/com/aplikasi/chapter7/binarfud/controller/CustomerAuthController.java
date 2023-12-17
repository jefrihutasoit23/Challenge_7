package com.aplikasi.chapter7.binarfud.controller;

import com.aplikasi.chapter7.binarfud.entity.Customer;
import com.aplikasi.chapter7.binarfud.repository.CustomerRepository;
import com.aplikasi.chapter7.binarfud.service.CustomerService;
import com.aplikasi.chapter7.binarfud.utils.SimpleStringUtils;
import com.aplikasi.chapter7.binarfud.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customersAuth")
public class CustomerAuthController {

    @Autowired
    private CustomerService customerService;

    SimpleStringUtils simpleStringUtils = new SimpleStringUtils();

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public TemplateResponse response;

    @PutMapping(value={"/update", "/update/"})
    public ResponseEntity<Map> updateCustomer(@RequestBody Customer customer) {
        try {
            return new ResponseEntity<Map>(customerService.updateCustomer(customer), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @DeleteMapping(value={"/delete", "/delete/"})
    public ResponseEntity<Map> deleteCustomer(@RequestBody Customer customer) {
        try {
            return new ResponseEntity<Map>(customerService.deleteCustomer(customer), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }
}

