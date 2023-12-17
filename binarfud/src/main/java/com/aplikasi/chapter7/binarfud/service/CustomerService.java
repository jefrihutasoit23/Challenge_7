package com.aplikasi.chapter7.binarfud.service;

import com.aplikasi.chapter7.binarfud.entity.Customer;

import java.util.Map;

public interface CustomerService {
    Map addCustomer(Customer customer);
    Map updateCustomer(Customer customer);
    Map deleteCustomer(Customer customer);
    Map getByID(Long user);
}

