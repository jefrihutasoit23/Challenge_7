package com.aplikasi.chapter7.binarfud.service.impl;

import com.aplikasi.chapter7.binarfud.entity.Order;
import com.aplikasi.chapter7.binarfud.entity.Customer;
import com.aplikasi.chapter7.binarfud.repository.OrderRepository;
import com.aplikasi.chapter7.binarfud.repository.CustomerRepository;
import com.aplikasi.chapter7.binarfud.service.OrderService;
import com.aplikasi.chapter7.binarfud.utils.Config;
import com.aplikasi.chapter7.binarfud.utils.TemplateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TemplateResponse response;

    @Override
    public Map createOrder(Order order) {
        try {
            log.info("create Order");
            return response.sukses(orderRepository.save(order));
        }catch (Exception e){
            log.error("create Order error: "+e.getMessage());
            return response.Error("create Order ="+e.getMessage());
        }
    }

    @Override
    public List<Order> getOrders() {
        log.info("get all Orders");
        return orderRepository.findAll();
    }

    @Override
    public Map getByID(Long order) {
        Optional<Order> getBaseOptional = orderRepository.findById(order);
        if(getBaseOptional.isEmpty()){
            return response.notFound(getBaseOptional);
        }
        return response.templateSukses(getBaseOptional);
    }

    @Override
    public Map getByCustomerId(Long CustomerId) {
        try {
            log.info("get order by user");
            if (CustomerId == null) {
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<Customer> chekDataDBCustomer = customerRepository.findById(CustomerId);
            if (chekDataDBCustomer.isEmpty()) {
                return response.Error(Config.USER_NOT_FOUND);
            }
            chekDataDBCustomer.get().setId(CustomerId);
            Optional<Order> getBaseOptional = orderRepository.findByCustomerId(chekDataDBCustomer.get());
            if(getBaseOptional.isEmpty()){
                return response.notFound(getBaseOptional);
            }
            return response.templateSukses(getBaseOptional);
        }catch (Exception e){
            log.error("get order by Customer error: "+e.getMessage());
            return response.Error("get order by Customer ="+e.getMessage());
        }
    }
}
